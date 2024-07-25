package com.doenerbestelltool.service.doenerbestelltool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doenerbestelltool.service.doenerbestelltool.entity.CustomerEntity;
import com.doenerbestelltool.service.doenerbestelltool.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerEntity getCustomerEntityByName(String cusForename, String cusSurename) {
		if (customerRepository.findByName(cusForename, cusSurename) != null) {
			return customerRepository.findByName(cusForename, cusSurename);
		}
		CustomerEntity saveEntity = new CustomerEntity();
		saveEntity.setForname(cusForename);
		saveEntity.setSurname(cusSurename);
		return customerRepository.saveAndFlush(saveEntity);
	}

}
