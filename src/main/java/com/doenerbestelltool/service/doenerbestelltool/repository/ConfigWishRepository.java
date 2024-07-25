package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.doenerbestelltool.service.doenerbestelltool.entity.ConfigurationEntity;

@Repository
public interface ConfigWishRepository extends CrudRepository<ConfigurationEntity, Integer>{
}
