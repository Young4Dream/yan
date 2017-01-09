/**
 * 
 */
package com.tstar.res.service;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResDevicePort;

/**
 * @author zhumengfeng
 *
 */
public interface ResDevicePortService {

	int countByCriteria(Map<String, Object> criteria);
	
	int countUsable(Map<String, Object> criteria);
	
	List<ResDevicePort> selectByPage(Map<String, Object> criteria);
	
	List<ResDevicePort> selectUsable(Map<String, Object> criteria);
	
	String[] insert(ResDevicePort obj);
	
	String[] update(ResDevicePort obj);
	
	String[] delete(String id);

}
