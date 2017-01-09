/**
 * 
 */
package com.tstar.res.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResDevicePortMapper;
import com.tstar.res.model.ResDevicePort;
import com.tstar.res.service.ResDevicePortService;
import com.tstar.util.UUID;

/**
 * @author lianjuan
 *
 */
@Service
public class ResDevicePortServiceImpl implements ResDevicePortService {

	@Resource
	private ResDevicePortMapper dao;
	
	public int countByCriteria(Map<String, Object> criteria) {
		return dao.countByCriteria(criteria);
	}

	public int countUsable(Map<String, Object> criteria) {
		return dao.countUsable(criteria);
	}

	public List<ResDevicePort> selectByPage(Map<String, Object> criteria) {
		return dao.selectByPage(criteria);
	}

	public List<ResDevicePort> selectUsable(Map<String, Object> criteria) {
		return dao.selectUsable(criteria);
	}

	public String[] insert(ResDevicePort obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResDevicePort obj) {
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
