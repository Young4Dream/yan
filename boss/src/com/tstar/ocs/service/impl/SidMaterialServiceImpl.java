/**
 * 
 */
package com.tstar.ocs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidMaterialMapper;
import com.tstar.ocs.model.SidMaterial;
import com.tstar.ocs.service.SidMaterialService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SidMaterialServiceImpl implements SidMaterialService {

	@Resource
	private SidMaterialMapper dao;
	
	public List<SidMaterial> findAll() {
		return dao.selectAll();
	}

	public String[] insert(SidMaterial obj) {
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidMaterial obj) {
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
