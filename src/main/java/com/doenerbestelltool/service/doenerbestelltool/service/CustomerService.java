package com.doenerbestelltool.service.doenerbestelltool.service;

import com.doenerbestelltool.service.doenerbestelltool.entity.CustomerEntity;

public interface CustomerService {

	CustomerEntity getCustomerEntityByName(String cusForename, String cusSurename);

}
