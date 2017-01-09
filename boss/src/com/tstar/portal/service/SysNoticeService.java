/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysNotice;

/**
 * @author zhumengfeng
 *
 */
public interface SysNoticeService {

	int countByCriteria(Map<String, Object> map);
	
	List<SysNotice> findByPage(Map<String, Object> map);
	
	List<SysNotice> findTop10();
	
	String[] insert(SysNotice obj);
	
	String[] update(SysNotice obj);
	
	String[] delete(String id);
	
}
