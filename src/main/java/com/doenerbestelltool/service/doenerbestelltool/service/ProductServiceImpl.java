package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.ProductEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductEntity getProductByValues(String product, Integer size) {
		return productRepository.findProductByValues(product, size);
	}

	@Override
	public ProductEntity findById(Integer id) {
		Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
		return optionalProductEntity.isPresent() ? optionalProductEntity.get():null;
	}

	@Override
	public List<ProductEntity> findAllSauces() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity createProduct(String product, String prize, Integer size) {
		return productRepository.saveAndFlush(new ProductEntity(null, product, prize, size));
	}
}
