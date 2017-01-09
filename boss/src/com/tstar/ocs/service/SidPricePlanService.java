package com.tstar.ocs.service;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.SidPricePlan;

public interface SidPricePlanService {
	int countByCriteria(Map<String, Object> map);
	
	List<SidPricePlan> selectByCriteria(Map<String, Object> map);
	
	String[] insert(SidPricePlan obj);
	
	String[] update(SidPricePlan obj);
	
	String[] delete(String id);
	
	List<SidPricePlan> selectReleasedPublicPlan();
	
	List<SidPricePlan> selectOrderableByBusiness(String businessType);
}
