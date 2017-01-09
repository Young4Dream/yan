package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidOperatorMapper;
import com.tstar.ocs.dao.SidOperatorRateMapper;
import com.tstar.ocs.dao.SidOperatorTrunkMapper;
import com.tstar.ocs.model.SidOperator;
import com.tstar.ocs.service.SidOperatorService;
import com.tstar.util.UUID;

@Service
public class SidOperatorServiceImpl implements SidOperatorService {

	@Resource
	private SidOperatorMapper dao;
	
	@Resource
	private SidOperatorTrunkMapper daoTrunk;
	
	@Resource
	private SidOperatorRateMapper daoRate;
	
	public List<SidOperator> selectAll() {
		return dao.selectAll();
	}

	public String[] insert(SidOperator obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidOperator obj) {
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		daoTrunk.deleteByOpId(id);
		daoRate.deleteByOpId(id);
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
