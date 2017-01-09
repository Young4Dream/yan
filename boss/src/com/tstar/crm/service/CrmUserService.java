/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.CrmUser;

/**
 * @author zhumengfeng
 *
 */
public interface CrmUserService {

	CrmUser selectByPrimaryKey(String id);
	
	Map<String, Object> selectFullInfoById(String id);
	
	Map<String, Object> selectFullInfoByBusinessKey(String businessKey);
	
	int countByCriteria(Map<String, Object> map);
	
	List<CrmUser> selectByPage(Map<String, Object> map);
}
