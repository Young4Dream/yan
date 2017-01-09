package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidRateItemMapper;
import com.tstar.ocs.model.SidRateItem;
import com.tstar.ocs.service.SidRateItemService;
import com.tstar.util.UUID;

@Service
public class SidRateItemServiceImpl implements SidRateItemService {

	@Resource
	private SidRateItemMapper dao;
	
	public List<SidRateItem> selectByFk(String fk) {
		return dao.selectByRateId(fk);
	}

	public String[] insert(SidRateItem obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidRateItem obj) {
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
