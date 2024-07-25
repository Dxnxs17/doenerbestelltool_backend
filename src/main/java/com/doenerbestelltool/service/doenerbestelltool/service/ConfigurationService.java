package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;

public interface ConfigurationService {

	List<ConfigurationEntity> getAllConfigurations();

	Integer count();

	void saveConfigurationEntity(ConfigurationEntity configurationEntity);

}
