package com.tstar.ocs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.CdrSourceMapper;
import com.tstar.ocs.model.CdrSource;
import com.tstar.ocs.service.CdrSourceService;
import com.tstar.util.UUID;

@Service
public class CdrSourceServiceImpl implements CdrSourceService {

	@Resource
	private CdrSourceMapper daoCdrSource;
	
	public List<CdrSource> selectAll() {
		return daoCdrSource.selectAll();
	}
	
	public String[] insert(CdrSource obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = daoCdrSource.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}
	
	public String[] update(CdrSource obj) {
		obj.setUpdateTime(new Date());
		int res = daoCdrSource.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = daoCdrSource.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
}
