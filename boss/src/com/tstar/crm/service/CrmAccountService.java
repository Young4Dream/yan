/**
 * 
 */
package com.tstar.crm.service;

import com.tstar.crm.model.CrmAccount;

/**
 * @author zhumengfeng
 *
 */
public interface CrmAccountService {
	
	CrmAccount selectByCustomerId(String customerId);
	
	CrmAccount selectByPrimaryKey(String id);
	
}
