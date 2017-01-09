package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidOperatorRateMapper;
import com.tstar.ocs.model.SidOperatorRate;
import com.tstar.ocs.service.SidOperatorRateService;
import com.tstar.util.UUID;

@Service
public class SidOperatorRateServiceImpl implements SidOperatorRateService {

	@Resource
	private SidOperatorRateMapper dao;
	
	public List<SidOperatorRate> selectByFk(String fk) {
		return dao.selectByOpId(fk);
	}

	public String[] insert(SidOperatorRate obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidOperatorRate obj) {
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
