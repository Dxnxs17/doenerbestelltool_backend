package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.SauceEntity;

@Repository
public interface SauceRepository extends JpaRepository<SauceEntity, Integer> {

	@Query(value = "select * from sauce where Sauce = ?1", nativeQuery = true)
	SauceEntity findSauceByValue(String sauce);
}
