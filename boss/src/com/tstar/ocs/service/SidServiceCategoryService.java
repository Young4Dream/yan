package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.SidServiceCategory;

public interface SidServiceCategoryService {
	List<SidServiceCategory> selectAll();
	
	String[] insert(SidServiceCategory obj);
	
	String[] update(SidServiceCategory obj);
	
	String[] delete(String id);
}
