package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.MeatEntity;
import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.MeatRepository;

@Service
public class MeatServiceImpl implements MeatService{

	@Autowired
	MeatRepository meatRepository;
	
	@Override
	public MeatEntity getMeatEntityByValue(String meat) {
		if(meatRepository.findByValue(meat) != null) {
			return meatRepository.findByValue(meat);
		}
		return null;
	}

	@Override
	public MeatEntity findMeatById(Integer id) {
		Optional<MeatEntity> optionalMeatEntity = meatRepository.findById(id);
		return optionalMeatEntity.isPresent() ? optionalMeatEntity.get() : null;
	}

	@Override
	public List<MeatEntity> findAllMeats() {
		return meatRepository.findAll();
	}

	@Override
	public MeatEntity createMeat(String meat) {
		return meatRepository.saveAndFlush(new MeatEntity(null, meat));
	}
}
