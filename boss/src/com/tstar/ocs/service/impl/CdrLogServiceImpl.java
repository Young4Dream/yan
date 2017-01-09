package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.CdrLogMapper;
import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.service.CdrLogService;

@Service
public class CdrLogServiceImpl implements CdrLogService {

	@Resource
	private CdrLogMapper daoCdrLog;
	
	public List<CdrLog> selectByPage(int start, int length) {
		return daoCdrLog.selectByPage(start, length);
	}
	
	public int countAll() {
		return daoCdrLog.countAll();
	}

}
