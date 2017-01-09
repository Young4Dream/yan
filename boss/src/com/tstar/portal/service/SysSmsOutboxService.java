/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysSmsOutbox;

/**
 * @author zhumengfeng
 *
 */
public interface SysSmsOutboxService {

	int countByCriteria(Map<String, Object> map);
	
	List<SysSmsOutbox> findByPage(Map<String, Object> map);
	
	String[] insert(SysSmsOutbox obj);
	
	String[] update(SysSmsOutbox obj);
	
	String[] delete(String id);
	
	String[] send(String id);
	
	String[] send(SysSmsOutbox obj);
	
}
