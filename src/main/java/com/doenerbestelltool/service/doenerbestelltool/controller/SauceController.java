package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.SauceService;

@RestController
public class SauceController {

	@Autowired
	SauceService sauceService;
	
	@GetMapping(value = "/sauce", produces = MediaType.APPLICATION_JSON_VALUE)
	public SauceEntity getSauceById(
			@RequestParam(required = true) Integer id
			){
		return sauceService.findById(id);
	}
	
	@GetMapping(value = "/sauces", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SauceEntity> getAllSauces(){
		return sauceService.findAllSauces();
	}
	
	@PostMapping(value = "/sauce", produces = MediaType.APPLICATION_JSON_VALUE)
	public SauceEntity createSauce(@RequestParam(required = true) String sauce) {
		return sauceService.createSauce(sauce);
	}
	
}
