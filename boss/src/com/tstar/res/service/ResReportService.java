/**
 * 
 */
package com.tstar.res.service;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResReport;

/**
 * @author zhumengfeng
 *
 */
public interface ResReportService {

	int countByCriteria(Map<String, Object> criteria);
	
	List<ResReport> findByPage(Map<String, Object> criteria);
	
	ResReport findByKey(String key);
	
	String[] insert(ResReport obj);
	
	String[] update(ResReport obj);
	
	String[] delete(String id);

}
