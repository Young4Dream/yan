/**
 * 
 */
package com.tstar.res.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tstar.res.dao.ResDeptMapper;
import com.tstar.res.model.ResDept;
import com.tstar.res.service.ResDeptService;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class ResDeptServiceImpl implements ResDeptService {
	
	@Resource
	ResDeptMapper dao;

	public List<ResDept> selectRoot() {
		return dao.selectRoot();
	}

	public List<ResDept> selectChildren(String parentId) {
		return dao.selectChildren(parentId);
	}

	public JSONArray findAll2Tree() {
		JSONArray arr = new JSONArray();
		List<ResDept> lst = dao.selectAll();
		for (ResDept dept : lst) {
			String str = "{'id':'" + dept.getId() 
				+ "','pId':'" + dept.getParentId() 
				+ "','name':'" + dept.getName()
				+ "','deptNo':'" + dept.getDeptNo()
				+ "','deptCode':'" + dept.getDeptCode()
				+ "','deptDesc':'" + dept.getDeptDesc()
				+ "','open':'false'}";
			JSONObject obj = JSON.parseObject(str); 
			arr.add(obj);
		}
		return arr;
	}
	
	public JSONArray findAll2Tree4Choosed() {
		JSONArray arr = new JSONArray();
		List<ResDept> lst = dao.selectAll();
		for (ResDept dept : lst) {
			String str = "{'id':'" + dept.getId() 
				+ "','pId':'" + dept.getParentId() 
				+ "','name':'" + dept.getDeptNo() + " " + dept.getName()
				+ "','open':'false'}";
			JSONObject obj = JSON.parseObject(str); 
			arr.add(obj);
		}
		return arr;
	}
	
	public String nextDeptCode(String parentId) {
		String maxCode = StringUtil.isEmpty(parentId) ? dao.selectRootMaxDeptCode() : dao.selectMaxDeptCode(parentId);
		if (StringUtil.isEmpty(maxCode)) {
			if (StringUtil.isEmpty(parentId)) {
				return "0001";
			} else {
				ResDept dept = dao.selectByPrimaryKey(parentId);
				return dept.getDeptCode() + "0001";
			}
		}
		int beginIndex = maxCode.length() - 4;
		String prefix = maxCode.substring(0, beginIndex);
		String suffix = maxCode.substring(beginIndex);
		int nextVal = Integer.parseInt(suffix) + 1;
		return prefix + (new DecimalFormat("0000")).format(nextVal);
	}

	public String[] insert(ResDept obj) {
		obj.setId(UUID.get());
		int res = dao.insert(obj);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(ResDept obj) {
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

	public String[] deleteByCode(String code) {
		int res = dao.deleteByCode(code);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}
	
}
