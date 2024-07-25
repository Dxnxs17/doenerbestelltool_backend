package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.entity.MeatEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.MeatService;
import com.doenerbestelltool.service.doenerbestelltool.service.SauceService;

@RestController
public class MeatController {

	@Autowired
	MeatService meatService;
	
	@GetMapping(value = "/meat", produces = MediaType.APPLICATION_JSON_VALUE)
	public MeatEntity getMeateById(
			@RequestParam(required = true) Integer id
			){
		return meatService.findMeatById(id);
	}
	
	@GetMapping(value = "/meats", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MeatEntity> getAllMeats(){
		return meatService.findAllMeats();
	}
	
	@PostMapping(value = "/meat", produces = MediaType.APPLICATION_JSON_VALUE)
	public MeatEntity createMeat(@RequestParam(required = true) String meat) {
		return meatService.createMeat(meat);
	}
	
}
