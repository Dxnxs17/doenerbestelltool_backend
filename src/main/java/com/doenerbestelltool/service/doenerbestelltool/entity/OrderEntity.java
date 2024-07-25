package com.doenerbestelltool.service.doenerbestelltool.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid" )
	private Integer orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerid")
	private CustomerEntity customerEntity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "configurationid")
	private ConfigurationEntity configurationEntity;
	
	@Column(name = "Date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime date;
}