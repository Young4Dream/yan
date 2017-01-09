/**
 * 
 */
package com.tstar.ac.service;

import java.util.List;
import java.util.Map;

import com.tstar.ac.model.AcAction;
import com.tstar.ac.model.AcCommand;

/**
 * @author zhumengfeng
 *
 */
public interface AcActionService {
	
	int countByCriteria(Map<String, Object> map);
	
	List<AcAction> selectByPage(Map<String, Object> map);
	
	List<AcCommand> selectCmdsByActId(String actionId);
	
	String[] reset(String actionId);

}
