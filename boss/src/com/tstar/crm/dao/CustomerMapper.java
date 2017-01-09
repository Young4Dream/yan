package com.tstar.crm.dao;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    int countByCriteria(Map<String, Object> criteria);
    
    List<Customer> selectByPage(Map<String, Object> criteria);
       
}