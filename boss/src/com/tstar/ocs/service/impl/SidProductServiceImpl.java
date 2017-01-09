/**
 * 
 */
package com.tstar.ocs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.ocs.dao.SidProductMapper;
import com.tstar.ocs.model.SidProduct;
import com.tstar.ocs.service.SidProductService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class SidProductServiceImpl implements SidProductService {

	@Resource
	private SidProductMapper daoSidProduct;
	
	public int countAll() {
		return daoSidProduct.countAll();
	}

	public List<SidProduct> selectByPage(int start, int length) {
		return daoSidProduct.selectByPage(start, length);
	}
	
	public List<SidProduct> selectRoot() {
		return daoSidProduct.selectRoot();
	}
	
	public List<SidProduct> selectChildren() {
		return daoSidProduct.selectChildren();
	}

	public String[] insert(SidProduct obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int res = daoSidProduct.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(SidProduct obj) {
		obj.setUpdateTime(new Date());
		int res = daoSidProduct.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int res = daoSidProduct.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

	public List<SidProduct> selectChildrenByPage(String parentId, int start, int length) {
		return daoSidProduct.selectChildrenByPage(parentId, start, length);
	}
	
	public int countChildren(String parentId) {
		return daoSidProduct.countChildren(parentId);
	}
}
