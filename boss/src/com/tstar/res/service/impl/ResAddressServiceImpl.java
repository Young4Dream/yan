/**
 * 
 */
package com.tstar.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tstar.res.dao.ResAddressMapper;
import com.tstar.res.model.ResAddress;
import com.tstar.res.service.ResAddressService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResAddressServiceImpl implements ResAddressService {

	@Resource
	private ResAddressMapper dao;
	
	public List<ResAddress> findAll() {
		return dao.selectAll();
	}
	
	public JSONArray findAll2Tree() {
		JSONArray arr = new JSONArray();
		List<ResAddress> lst = dao.selectAll();
		for (ResAddress address : lst) {
			String str = "{'id':'" + address.getId() 
				+ "','pId':'" + address.getParentId() 
				+ "','name':'" + address.getName()
				+ "','vlan':'" + address.getVlan()
				+ "','accPrefix':'" + address.getAccPrefix()
				+ "','businessArea':'" + address.getBusinessArea()
				+ "','userArea':'" + address.getUserArea()
				+ "','open':'false'}";
			JSONObject obj = JSON.parseObject(str); 
			arr.add(obj);
		}
		return arr;
	}

	public String[] insert(ResAddress obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResAddress obj) {
		int res = dao.updateByPrimaryKeySelective(obj);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String id) {
		int count = dao.countByParentId(id);
		if (count > 0) {
			return new String[]{"2", "不能删除有子节点的地址"};
		}
		int res = dao.deleteByPrimaryKey(id);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
