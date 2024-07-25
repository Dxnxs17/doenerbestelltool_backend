package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.MeatEntity;

@Repository
public interface MeatRepository extends JpaRepository<MeatEntity, Integer>{

	@Query(value = "select * from meat where Meat = ?1", nativeQuery = true)
	MeatEntity findByValue(String meat);
}
