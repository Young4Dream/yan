package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidPlanRate;

public interface SidPlanRateService {
	List<SidPlanRate> selectByFk(String fk);
	
	String[] insert(SidPlanRate obj);
	
	String[] update(SidPlanRate obj);
	
	String[] delete(String id);
}
