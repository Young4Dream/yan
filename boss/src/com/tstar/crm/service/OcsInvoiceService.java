/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

import com.tstar.crm.model.OcsInvoice;
import com.tstar.crm.model.OcsInvoiceItem;

/**
 * @author zhumengfeng
 *
 */
public interface OcsInvoiceService {

	OcsInvoice findByPrimaryKey(String id);
	
	int countByCriteria(Map<String, Object> map);
	
	List<OcsInvoice> findByPage(Map<String, Object> map);
	
	List<OcsInvoiceItem> findItemsByInvoiceId(String invoiceId);
	
	String[] cancel(String id);
	
}
