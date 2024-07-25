package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;

public interface SpecialWishesService {

	SpecialWishesEntity getSpecialWishesByValue(String specialWishes);

	SpecialWishesEntity findById(Integer id);

	List<SpecialWishesEntity> findAllSauces();

	SpecialWishesEntity createSpecialWish(String specialWish);

}
