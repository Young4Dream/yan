/**
 * 
 */
package com.tstar.activiti.service;

import java.util.List;
import java.util.Map;

/**
 * @author zhumengfeng
 *
 */
public interface OpTaskService {
	
	int countAll(String userId);
	
	List<Map<String, Object>> findByPage(String userId, int start, int length);
	
	List<Map<String, Object>> getTaskFormProperties(String taskId);
	
	String[] claim(Map<String, String> obj);
	
	String[] handle(String taskId, Map<String, String> obj);
	
	int countRunning();
	
	List<Map<String, Object>> findRunningByPage(int start, int length);
	
	List<Map<String, Object>> findFinishedByPage(int start, int length);
}
