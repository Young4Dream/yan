/**
 * 
 */
package com.tstar.res.service;

import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResDevice;

/**
 * @author zhumengfeng
 *
 */
public interface ResDeviceService {

	int countByCriteria(Map<String, Object> criteria);
	
	List<ResDevice> selectByPage(Map<String, Object> criteria);
	
	String[] insert(ResDevice obj);
	
	String[] update(ResDevice obj);
	
	String[] delete(String id);
	
	String[] generatePort(String id);

}
