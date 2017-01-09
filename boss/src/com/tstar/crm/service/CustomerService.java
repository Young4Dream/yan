package com.tstar.crm.service;


import java.util.List;
import java.util.Map;

import com.tstar.crm.model.Customer;

public interface CustomerService {
	
	int countByCriteria(Map<String, Object> criteria);
	
	List<Customer> selectByPage(Map<String, Object> criteria);
	
	Customer selectByPrimaryKey(String id);
	
	String[] insert(Customer obj);
	
	String[] update(Customer obj);
	
	String[] delete(String id);
	
}
