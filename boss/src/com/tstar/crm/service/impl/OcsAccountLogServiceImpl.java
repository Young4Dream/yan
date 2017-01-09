/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.OcsAccountLogMapper;
import com.tstar.crm.service.OcsAccountLogService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class OcsAccountLogServiceImpl implements OcsAccountLogService {

	@Resource
	private OcsAccountLogMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}

	public List<Map<String, Object>> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

}
