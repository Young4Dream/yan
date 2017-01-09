package com.tstar.ocs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.CdrMapper;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.service.CdrService;

@Service
public class CdrServiceImpl implements CdrService {

	@Resource
	private CdrMapper daoCdr;
	
	public int countAll() {
		return daoCdr.countAll();
	}
	
	public int countByCriteria(Map<String, Object> map) {
		return daoCdr.countByCriteria(map);
	}

	public List<Cdr> selectByPage(Map<String, Object> map) {
		return daoCdr.selectByPage(map);
	}

}
