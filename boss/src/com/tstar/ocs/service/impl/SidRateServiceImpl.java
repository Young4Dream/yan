package com.tstar.ocs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidRateItemMapper;
import com.tstar.ocs.dao.SidRateMapper;
import com.tstar.ocs.model.SidRate;
import com.tstar.ocs.model.SidRateItem;
import com.tstar.ocs.service.SidRateService;
import com.tstar.util.UUID;

@Service
public class SidRateServiceImpl implements SidRateService {

	@Resource
	private SidRateMapper dao;
	
	@Resource
	private SidRateItemMapper daoItem;
	
	public List<SidRate> selectAll() {
		return dao.selectAll();
	}

	public int countByCriteria(Map<String, Object> map) {
		return dao.countAll(map);
	}

	public List<SidRate> selectByCriteria(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	public String[] insert(SidRate obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		
		// 根据费率类型，插入明细
		int rateType = obj.getRateType();
		if (rateType == 0) {
			// 标准费率
			SidRateItem item = new SidRateItem();
			item.setId(UUID.get());
			item.setRateId(obj.getId());
			item.setPrice(obj.getPrice());
			daoItem.insertSelective(item);
		} else if (rateType == 1) {
			// 固定费率
			SidRateItem item = new SidRateItem();
			item.setId(UUID.get());
			item.setRateId(obj.getId());
			item.setBaseFee(obj.getBaseFee());
			daoItem.insertSelective(item);
		} else if (rateType == 2) {
			// T+1费率
			SidRateItem item = new SidRateItem();
			item.setId(UUID.get());
			item.setRateId(obj.getId());
			item.setBaseFee(obj.getBaseFee());
			item.setPrice(obj.getPrice());
			item.setBaseUsage(obj.getBaseUsage());
			daoItem.insertSelective(item);
		} else if (rateType == 3) {
			// 阶梯费率
			for (int i = 0; i < obj.getThreshold(); i++) {
				SidRateItem item = new SidRateItem();
				item.setId(UUID.get());
				item.setRateId(obj.getId());
				item.setThreshold((i + 1) * 1000);
				daoItem.insertSelective(item);
			}
		}
		
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidRate obj) {
		obj.setUpdateTime(new Date());
		obj.setRateType(null);
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		daoItem.deleteByRateId(id);
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
