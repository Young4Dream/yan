/**
 * 
 */
package com.tstar.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.CrmAccountMapper;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.service.CrmAccountService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class CrmAccountServiceImpl implements CrmAccountService {

	@Resource
	private CrmAccountMapper dao;
	
	public CrmAccount selectByCustomerId(String customerId) {
		return dao.selectByCustomerId(customerId);
	}
	
	public CrmAccount selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

}
