package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;

@Repository
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, Integer>{
}
