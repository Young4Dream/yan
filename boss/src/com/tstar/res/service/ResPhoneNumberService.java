/**
 * 
 */
package com.tstar.res.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tstar.res.model.ResPhoneNumber;

/**
 * @author zhumengfeng
 *
 */
public interface ResPhoneNumberService {

	int countByCriteria(Map<String, Object> criteria);
	
	List<ResPhoneNumber> selectByPage(Map<String, Object> criteria);
	
	String[] insert(ResPhoneNumber obj);
	
	String[] update(ResPhoneNumber obj);
	
	String[] delete(String id);
	
	String[] lockPhoneNumber(String phoneNumber, Date unlockTime);
	
}
