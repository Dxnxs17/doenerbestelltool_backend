package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.SauceRepository;

@Service
public class SauceServiceImpl implements SauceService{

	@Autowired
	SauceRepository sauceRepository;
	
	@Override
	public SauceEntity findById(Integer id) {
		Optional<SauceEntity> optionalSauce = sauceRepository.findById(id);
		return optionalSauce.get();
	}

	@Override
	public List<SauceEntity> findAllSauces() {
		return sauceRepository.findAll();
	}

	@Override
	public SauceEntity getSauceEntityByValue(String sauce) {
		return sauceRepository.findSauceByValue(sauce);
	}

	@Override
	public SauceEntity createSauce(String sauce) {
		SauceEntity saveEntity = new SauceEntity(null, sauce);
		return sauceRepository.saveAndFlush(saveEntity);
	}
}
