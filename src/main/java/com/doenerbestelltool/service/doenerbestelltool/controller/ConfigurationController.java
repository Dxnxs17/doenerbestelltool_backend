package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.ConfigurationService;

@RestController
public class ConfigurationController {
	
	@Autowired
	ConfigurationService configurationService;
	
	@GetMapping(value = "/configurations", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ConfigurationEntity> getConfigurations(){
		return configurationService.getAllConfigurations();
	}
	
}
