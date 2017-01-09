/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.CrmOrder;

/**
 * @author zhumengfeng
 *
 */
public interface CrmOrderService {

	int countByCriteria(Map<String, Object> criteria);
	
	List<CrmOrder> selectByPage(Map<String, Object> criteria);
	
	String[] insert(CrmOrder obj) throws Exception ;
	
	String[] update(CrmOrder obj);
	
	String[] editUser(CrmOrder obj);
	
	String[] changeUser(CrmOrder obj) throws Exception;

	String[] moveUser(CrmOrder obj) throws Exception;

	String[] transferUser(CrmOrder obj) throws Exception;

	String[] delete(String id);
	
	String[] deleteUser(CrmOrder obj) throws Exception;
	
	String[] adjustUser(CrmOrder obj) throws Exception;
	
	String[] resetUser(CrmOrder obj) throws Exception;
	
	String[] deleteUserImmediately(String userId);
	
	List<Map<String, Object>> selectPlanInOrder(String customerId, String businessKey);
	
	List<Map<String, Object>> selectProductInOrder(String customerId, String businessKey);
	
	List<Map<String, Object>> selectFeeInOrder(String customerId, String businessKey);
	
	List<Map<String, Object>> selectPlanInOrderByUser(String userId);
	
	List<Map<String, Object>> selectProductInOrderByUser(String userId);
	
	List<Map<String, Object>> selectFeeInOrderByUser(String userId);
	
}
