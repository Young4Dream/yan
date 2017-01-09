/**
 * 
 */
package com.tstar.res.service;

import java.util.List;

import com.tstar.res.model.ResUserPort;

/**
 * @author zhumengfeng
 *
 */
public interface ResUserPortService {

	List<ResUserPort> selectByUserId(String userId);
	
	String[] insert(ResUserPort obj);
	
	String[] update(ResUserPort obj);
	
	String[] delete(String id);
}
