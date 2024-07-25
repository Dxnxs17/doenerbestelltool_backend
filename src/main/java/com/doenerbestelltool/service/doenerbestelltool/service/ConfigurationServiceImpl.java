package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{

	@Autowired
	ConfigurationRepository configurationRepository;
	
	@Override
	public List<ConfigurationEntity> getAllConfigurations() {
		return configurationRepository.findAll();
	}

	@Override
	public Integer count() {
		return (int) (configurationRepository.count() + 1);
	}

	@Override
	public void saveConfigurationEntity(ConfigurationEntity configurationEntity) {
		configurationRepository.saveAndFlush(configurationEntity);
	}
}
