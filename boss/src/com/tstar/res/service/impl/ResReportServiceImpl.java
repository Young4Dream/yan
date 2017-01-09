/**
 * 
 */
package com.tstar.res.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResReportMapper;
import com.tstar.res.model.ResReport;
import com.tstar.res.service.ResReportService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResReportServiceImpl implements ResReportService {

	@Resource
	private ResReportMapper dao;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public List<ResReport> findByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}
	
	public ResReport findByKey(String key) {
		return dao.selectByKey(key);
	}

	public String[] insert(ResReport obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResReport obj) {
		obj.setUpdateTime(new Date());
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
