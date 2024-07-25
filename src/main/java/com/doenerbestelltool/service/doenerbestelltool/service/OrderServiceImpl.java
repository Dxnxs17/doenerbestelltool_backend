package com.doenerbestelltool.service.doenerbestelltool.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.dto.OrderDto;
import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.CustomerEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.MeatEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.OrderEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.ProductEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	MeatService meatService;
	
	@Autowired
	SauceService sauceService;
	
	@Autowired
	SpecialWishesService specialWishesService;
	
	@Autowired
	ConfigurationService configurationService;
	
	@Override
	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public synchronized OrderEntity createOrder(String cusForename, String cusSurename, String product, String price, Integer size,
			String sauce1, String sauce2, String meat, String specialWishes, String specialInstruction,
			LocalDateTime orderDate) {
		CustomerEntity customerEntity = customerService.getCustomerEntityByName(cusForename, cusSurename);
		ProductEntity productEntity = productService.getProductByValues(product, size);
		MeatEntity meatEntity = meatService.getMeatEntityByValue(meat);
		SauceEntity sauceEntity1 = sauceService.getSauceEntityByValue(sauce1);
		SauceEntity sauceEntity2 = sauceService.getSauceEntityByValue(sauce2);
		SpecialWishesEntity specialWishesEntity = specialWishesService.getSpecialWishesByValue(specialWishes);
		Set<SpecialWishesEntity> specialWishesSet = new HashSet<SpecialWishesEntity>();
		specialWishesSet.add(specialWishesEntity);
		ConfigurationEntity configurationEntity = new ConfigurationEntity(configurationService.count(), productEntity, price, sauceEntity1, sauceEntity2, meatEntity, specialWishesSet, specialInstruction);
		configurationService.saveConfigurationEntity(configurationEntity);
		OrderEntity saveEntity = new OrderEntity((int) (orderRepository.count() + 1), customerEntity, configurationEntity, orderDate);
		orderRepository.saveAndFlush(saveEntity);
		return saveEntity;
	}
	
	@Override
	public synchronized OrderDto saveOrder(OrderDto orderDto) {
	    CustomerEntity customerEntity = customerService.getCustomerEntityByName(orderDto.getCusForename(), orderDto.getCusSurename());
	    ProductEntity productEntity = productService.getProductByValues(orderDto.getProduct(), orderDto.getSize());
	    MeatEntity meatEntity = meatService.getMeatEntityByValue(orderDto.getMeat());
	    SauceEntity sauceEntity1 = sauceService.getSauceEntityByValue(orderDto.getSauce1());
	    SauceEntity sauceEntity2 = sauceService.getSauceEntityByValue(orderDto.getSauce2());
	    Set<SpecialWishesEntity> specialWishesSet = new HashSet<>();
	    for(String wish : orderDto.getSpecialWishes()) {
	    	SpecialWishesEntity specialWishesEntity = specialWishesService.getSpecialWishesByValue(wish);
	    	specialWishesSet.add(specialWishesEntity);
	    }
	    ConfigurationEntity configurationEntity = new ConfigurationEntity(
	    	getLatestConfigId(),
	        productEntity, 
	        orderDto.getPrice(), 
	        sauceEntity1, 
	        sauceEntity2, 
	        meatEntity, 
	        specialWishesSet, 
	        orderDto.getSpecialInstruction()
	    );
	    
	    configurationService.saveConfigurationEntity(configurationEntity);
	    
	    OrderEntity orderEntity = new OrderEntity(
	    	getLatestOrderId(),	
	        customerEntity, 
	        configurationEntity, 
	        orderDto.getOrderDate()
	    );
	    orderRepository.saveAndFlush(orderEntity);
	       
	    return orderDto; 
	}

	private Integer getLatestConfigId() {
		return configurationService.getAllConfigurations().isEmpty() ? 1 : configurationService.count() + 1;
	}

	private Integer getLatestOrderId() {
		return (int) (orderRepository.findAll().isEmpty() ? 1 : orderRepository.count() + 1);
	}

	@Override
	public OrderEntity getOrderById(Integer id) {
		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(id);
		return optionalOrderEntity.isPresent() ? optionalOrderEntity.get() : null;
	}

	

}