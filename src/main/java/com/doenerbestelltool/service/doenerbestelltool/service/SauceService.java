package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;

public interface SauceService {

	SauceEntity findById(Integer id);

	List<SauceEntity> findAllSauces();

	SauceEntity getSauceEntityByValue(String sauce);

	SauceEntity createSauce(String sauce);

}
