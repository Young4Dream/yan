/**
 * 
 */
package com.tstar.res.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResAcc;

/**
 * @author zhumengfeng
 *
 */
public interface ResAccService {

	int countByCriteria(Map<String, Object> criteria);
	
	List<ResAcc> selectByPage(Map<String, Object> criteria);
	
	String[] insert(ResAcc obj);
	
	String[] update(ResAcc obj);
	
	String[] delete(String id);
	
	String[] lockAcc(String acc, Date unlockTime);
	
	String findTopUsable(String patterns, String businessType);
	
}
