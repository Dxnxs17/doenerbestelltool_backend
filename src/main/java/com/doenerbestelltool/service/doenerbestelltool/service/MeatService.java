package com.doenerbestelltool.service.doenerbestelltool.service;

import java.util.List;

import com.doenerbestelltool.service.doenerbestelltool.entity.MeatEntity;

public interface MeatService {

	MeatEntity getMeatEntityByValue(String meat);

	MeatEntity findMeatById(Integer id);

	List<MeatEntity> findAllMeats();

	MeatEntity createMeat(String meat);

}