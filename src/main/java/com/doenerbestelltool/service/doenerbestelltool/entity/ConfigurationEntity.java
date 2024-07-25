package com.doenerbestelltool.service.doenerbestelltool.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "configuration")
public class ConfigurationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CoID")
	private Integer configurationId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Product")
	private ProductEntity productEntity;
	
	@Column(name = "Price")
	private String price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Sauce1")
	private SauceEntity sauceEntity1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Sauce2")
	private SauceEntity sauceEntity2;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Meat")
	private MeatEntity meatEntity;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "configwish", joinColumns = @JoinColumn(name = "CoID"),
				inverseJoinColumns = @JoinColumn(name = "SWID"))
	private Set<SpecialWishesEntity> specialWhishes;
	
	@Column(name = "Special Instruction")
	private String specialInstruction;
}
