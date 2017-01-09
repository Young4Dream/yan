package com.tstar.ocs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidPricePlanMapper;
import com.tstar.ocs.model.SidPricePlan;
import com.tstar.ocs.service.SidPricePlanService;
import com.tstar.util.UUID;

@Service
public class SidPricePlanServiceImpl implements SidPricePlanService {

	@Resource
	private SidPricePlanMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countAll(map);
	}

	public List<SidPricePlan> selectByCriteria(Map<String, Object> map) {
		return dao.selectByPage(map);
	}
	
	public List<SidPricePlan> selectReleasedPublicPlan() {
		return dao.selectReleasedPublicPlan();
	}
	
	public List<SidPricePlan> selectOrderableByBusiness(String businessType) {
		return dao.selectOrderableByBusiness(businessType);
	}

	public String[] insert(SidPricePlan obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidPricePlan obj) {
		obj.setUpdateTime(new Date());
		int res = dao.updateByPrimaryKey(obj);
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
