package com.doenerbestelltool.service.doenerbestelltool.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "configwish")
public class ConfigWishEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CoID")
	private Integer configurationId;
	
	@ManyToOne
	@JoinColumn(name = "SWID")
	private SpecialWishesEntity specialWishesEntity;
	
}