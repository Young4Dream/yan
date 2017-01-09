package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidRateItem;

public interface SidRateItemService {
	List<SidRateItem> selectByFk(String fk);
	
	String[] insert(SidRateItem obj);
	
	String[] update(SidRateItem obj);
	
	String[] delete(String id);
}
