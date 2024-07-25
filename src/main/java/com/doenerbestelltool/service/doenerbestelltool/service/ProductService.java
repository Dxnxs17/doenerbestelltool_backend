package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.entity.ProductEntity;

public interface ProductService {

	ProductEntity getProductByValues(String product, Integer size);

	ProductEntity findById(Integer id);

	List<ProductEntity> findAllSauces();

	ProductEntity createProduct(String product, String prize, Integer size);

}
