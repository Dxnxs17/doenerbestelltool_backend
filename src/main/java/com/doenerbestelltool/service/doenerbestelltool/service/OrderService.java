package com.doenerbestelltool.service.doenerbestelltool.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.dto.OrderDto;
import com.doenerbestelltool.service.doenerbestelltool.entity.OrderEntity;

public interface OrderService {

	List<OrderEntity> getAllOrders();

	OrderEntity createOrder(String cusForename, String cusSurename, String product, String price, Integer size, String sauce1, String sauce2, String meat, String specialWishes, String specialInstruction, LocalDateTime orderDate);
	
	OrderDto saveOrder(OrderDto orderDto);

	OrderEntity getOrderById(Integer id);

}
