package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidServiceCategoryMapper;
import com.tstar.ocs.model.SidServiceCategory;
import com.tstar.ocs.service.SidServiceCategoryService;
import com.tstar.util.UUID;

@Service
public class SidServiceCategoryServiceImpl implements SidServiceCategoryService {

	@Resource
	private SidServiceCategoryMapper dao;
	
	public List<SidServiceCategory> selectAll() {
		return dao.selectAll();
	}

	public String[] insert(SidServiceCategory obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidServiceCategory obj) {
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
