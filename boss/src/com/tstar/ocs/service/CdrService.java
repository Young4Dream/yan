package com.tstar.ocs.service;

import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.Cdr;

public interface CdrService {
	int countAll();
	int countByCriteria(Map<String, Object> map);
	List<Cdr> selectByPage(Map<String, Object> map);
}
