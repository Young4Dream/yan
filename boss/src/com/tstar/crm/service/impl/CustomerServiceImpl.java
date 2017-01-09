package com.tstar.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.CustomerMapper;
import com.tstar.crm.model.Customer;
import com.tstar.crm.service.CustomerService;
import com.tstar.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper dao;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}
	
	public Customer selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Customer> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public String[] insert(Customer obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(Customer obj) {
		obj.setUpdateTime(new Date());
		int res = dao.updateByPrimaryKey(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
}
