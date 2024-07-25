package com.doenerbestelltool.service.doenerbestelltool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doenerbestelltool.service.doenerbestelltool.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	@Query(value = "select * from product where Product = ?1 and `Size 1=Big/0=Small` = ?2", nativeQuery = true)
	ProductEntity findProductByValues(String product, Integer size);
}
