package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.entity.ProductEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.ProductService;
import com.doenerbestelltool.service.doenerbestelltool.service.SauceService;
import com.doenerbestelltool.service.doenerbestelltool.service.SpecialWishesService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductEntity getProductById(
			@RequestParam(required = true) Integer id
			){
		return productService.findById(id);
	}
	
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductEntity> getAllProductss(){
		return productService.findAllSauces();
	}
	
	@PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductEntity createProduct(
			@RequestParam(required = true) String product,
			@RequestParam(required = true) String prize,
			@RequestParam(required = true) Integer size
			) {
		return productService.createProduct(product, prize, size);
	}
	
}
