/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsBill;
import com.tstar.crm.model.OcsBillItem;
import com.tstar.portal.model.SysAccountItem;

/**
 * @author zhumengfeng
 *
 */
public interface OcsBillService {
	
	OcsBill selectByPrimaryKey(String id);
	
	int countByCriteria(Map<String, Object> map);
	
	List<Map<String, Object>> selectByPage(Map<String, Object> map);
	
	List<OcsBillItem> selectItemsByBillId(String billId);
	
	String[] generateOrderBill(String userId);
	
	String[] updateStatus(String billId, Integer status);
	
	String[] releaseBills(Map<String, Object> map);
	
	String[] releaseUserBill(String userId);
	
	String[] findRootCreditor(String customerId);
	
	SysAccountItem findAccountItem(String itemId, int itemType);
	
	List<Map<String, Object>> findAnotherBills(String customerId, String id);
	
	OcsBill findCustomerTopBill(String customerId);
	
	String pay(Map<String, String> obj) throws Exception;

	String createInvoice(Map<String, String> obj) throws Exception;
	
	List<Map<String, Object>> findItemsByCustomer(Map<String, String> map);
	
}
