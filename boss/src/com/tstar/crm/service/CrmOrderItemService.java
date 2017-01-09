/**
 * 
 */
package com.tstar.crm.service;

import com.tstar.crm.model.CrmOrderItem;

/**
 * @author zhumengfeng
 *
 */
public interface CrmOrderItemService {

	String[] insert(CrmOrderItem orderItem);
	
	String[] cancel(CrmOrderItem orderItem);
}
