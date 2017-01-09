/**
 * 
 */
package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

/**
 * @author zhumengfeng
 *
 */
public interface RefService {
	
	List<Map<String, String>> selectAll(String tableName);
	
	Map<String, String> selectById(String tableName, String id);
	
	String[] insert(String tableName, Map<String, String> map);
	
	String[] update(String tableName, Map<String, String> map);
	
	String[] delete(String tableName, String id);
	
}
