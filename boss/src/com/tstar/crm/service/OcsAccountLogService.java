/**
 * 
 */
package com.tstar.crm.service;

import java.util.List;
import java.util.Map;

/**
 * @author zhumengfeng
 *
 */
public interface OcsAccountLogService {

	int countByCriteria(Map<String, Object> map);
	List<Map<String, Object>> findByPage(Map<String, Object> map);
}
