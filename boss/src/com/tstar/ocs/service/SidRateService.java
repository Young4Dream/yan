package com.tstar.ocs.service;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.SidRate;

public interface SidRateService {
	List<SidRate> selectAll();
	
	int countByCriteria(Map<String, Object> map);
	
	List<SidRate> selectByCriteria(Map<String, Object> map);
	
	String[] insert(SidRate obj);
	
	String[] update(SidRate obj);
	
	String[] delete(String id);
}
