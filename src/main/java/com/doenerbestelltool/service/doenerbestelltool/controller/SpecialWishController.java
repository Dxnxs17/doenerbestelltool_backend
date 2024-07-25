package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.SauceService;
import com.doenerbestelltool.service.doenerbestelltool.service.SpecialWishesService;

@RestController
public class SpecialWishController {

	@Autowired
	SpecialWishesService specialWishesService;
	
	@GetMapping(value = "/specialWish", produces = MediaType.APPLICATION_JSON_VALUE)
	public SpecialWishesEntity getSpecialWishById(
			@RequestParam(required = true) Integer id
			){
		return specialWishesService.findById(id);
	}
	
	@GetMapping(value = "/specialWishes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SpecialWishesEntity> getAllSpecialWishes(){
		return specialWishesService.findAllSauces();
	}
	
	@PostMapping(value = "/specialWish", produces = MediaType.APPLICATION_JSON_VALUE)
	public SpecialWishesEntity createSauce(@RequestParam(required = true) String specialWish) {
		return specialWishesService.createSpecialWish(specialWish);
	}
	
}
