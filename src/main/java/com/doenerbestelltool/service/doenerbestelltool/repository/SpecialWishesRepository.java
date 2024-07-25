package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.SpecialWishesEntity;

@Repository
public interface SpecialWishesRepository extends JpaRepository<SpecialWishesEntity, Integer> {

	@Query(value = "select * from `special wishes` where Wish = ?1", nativeQuery = true)
	SpecialWishesEntity findByValue(String specialWishes);
}
