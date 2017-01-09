/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;

import com.tstar.portal.model.SysAccountItem;

/**
 * @author zhumengfeng
 *
 */
public interface SysAccountItemService {
	
	List<SysAccountItem> selectAll();

	String[] insert(SysAccountItem obj);
	
	String[] update(SysAccountItem obj);
	
	String[] delete(String id);
	
	String[] deleteByCode(String code);
}
