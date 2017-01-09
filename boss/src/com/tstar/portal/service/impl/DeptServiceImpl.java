package com.tstar.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.DeptMapper;
import com.tstar.portal.model.Dept;
import com.tstar.portal.model.ResultMap;
import com.tstar.portal.service.DeptService;
import com.tstar.util.UUID;

@Service
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptMapper dao;
	
	public List<ResultMap> getAllDepts() {
		return dao.selectAllDepts();
	}
	
	public String[] insert(Dept obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(Dept obj) {
		int res = dao.updateByPrimaryKey(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] deleteByCode(String code) {
		int res = dao.deleteByCode(code);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
