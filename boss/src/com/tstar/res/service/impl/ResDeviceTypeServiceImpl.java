/**
 * 
 */
package com.tstar.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.res.dao.ResDeviceTypeMapper;
import com.tstar.res.model.ResDeviceType;
import com.tstar.res.service.ResDeviceTypeService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResDeviceTypeServiceImpl implements ResDeviceTypeService {

	@Resource
	private ResDeviceTypeMapper dao;
	
	public List<ResDeviceType> selectAll() {
		return dao.selectAll();
	}

	public String[] insert(ResDeviceType obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResDeviceType obj) {
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
