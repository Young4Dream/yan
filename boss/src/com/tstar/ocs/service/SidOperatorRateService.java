package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidOperatorRate;

public interface SidOperatorRateService {
	List<SidOperatorRate> selectByFk(String fk);
	
	String[] insert(SidOperatorRate obj);
	
	String[] update(SidOperatorRate obj);
	
	String[] delete(String id);
}
