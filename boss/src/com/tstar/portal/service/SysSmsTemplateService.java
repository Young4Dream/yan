/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;

import com.tstar.portal.model.SysSmsTemplate;

/**
 * @author zhumengfeng
 *
 */
public interface SysSmsTemplateService {

	List<SysSmsTemplate> findByUser(String userName);
	
	SysSmsTemplate findById(String id);
	
	String[] insert(SysSmsTemplate obj);
	
	String[] update(SysSmsTemplate obj);
	
	String[] delete(String id);
	
}
