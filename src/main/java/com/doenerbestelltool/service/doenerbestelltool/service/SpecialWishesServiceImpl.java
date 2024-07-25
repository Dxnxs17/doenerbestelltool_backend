package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.SpecialWishesRepository;

@Service
public class SpecialWishesServiceImpl implements SpecialWishesService{

	@Autowired
	SpecialWishesRepository specialWishesRepository;
	
	@Override
	public SpecialWishesEntity getSpecialWishesByValue(String specialWishes) {
		return specialWishesRepository.findByValue(specialWishes);
	}

	@Override
	public SpecialWishesEntity findById(Integer id) {
		Optional<SpecialWishesEntity> optionalSpecialWish = specialWishesRepository.findById(id);
		return optionalSpecialWish.isPresent() ? optionalSpecialWish.get():null;
	}

	@Override
	public List<SpecialWishesEntity> findAllSauces() {
		return specialWishesRepository.findAll();
	}

	@Override
	public SpecialWishesEntity createSpecialWish(String specialWish) {
		return specialWishesRepository.saveAndFlush(new SpecialWishesEntity(null, specialWish));
	}
}