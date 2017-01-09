/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.SysWarnLog;

/**
 * @author zhumengfeng
 *
 */
public interface SysWarnLogService {

	int countByCriteria(Map<String, Object> map);
	
	List<SysWarnLog> findByPage(Map<String, Object> map);
	
	List<SysWarnLog> findTop10();
	
	String[] update(SysWarnLog obj);
	
}
