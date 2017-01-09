package com.tstar.ocs.service;

import java.util.List;

import com.tstar.ocs.model.CdrLog;

public interface CdrLogService {
	List<CdrLog> selectByPage(int start, int length);
	int countAll();
}
