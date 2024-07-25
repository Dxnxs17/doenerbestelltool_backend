package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	
	@Query(value =  "SELECT * FROM customer c where c.Forename = ?1 and c.Surename = ?2", nativeQuery = true)
	CustomerEntity findByName(String foreName, String sureName);
}
