/**
 * 
 */
package com.tstar.res.service;

import java.util.List;

import com.tstar.res.model.ResDeviceType;

/**
 * @author zhumengfeng
 *
 */
public interface ResDeviceTypeService {
	
	List<ResDeviceType> selectAll();
	
	String[] insert(ResDeviceType obj);
	
	String[] update(ResDeviceType obj);
	
	String[] delete(String id);
	
}
