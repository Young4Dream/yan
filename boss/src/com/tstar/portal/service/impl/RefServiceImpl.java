/**
 * 
 */
package com.tstar.portal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.RefMapper;
import com.tstar.portal.service.RefService;

/**
 * @author zhumengfeng
 *
 */
@Service
public class RefServiceImpl implements RefService {

	@Resource
	private RefMapper dao;
	
	public List<Map<String, String>> selectAll(String tableName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", tableName);
		return dao.selectAll(map);
	}

	public Map<String, String> selectById(String tableName, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", tableName);
		map.put("id", "'" + id + "'");
		return dao.selectByPrimaryKey(map);
	}

	public String[] insert(String tableName, Map<String, String> map) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("tableName", tableName);
		map1.put("id", "'" + map.get("id") + "'");
		map1.put("name", "'" + map.get("name") + "'");
		int res = dao.insert(map1);
		if (res > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] update(String tableName, Map<String, String> map) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("tableName", tableName);
		map1.put("id", "'" + map.get("id") + "'");
		map1.put("name", "'" + map.get("name") + "'");
		int res = dao.updateByPrimaryKey(map1);
		if (res > 0) {
			return new String[]{"0", "修改成功！"};
		} else {
			return new String[]{"1", "修改失败！"};
		}
	}

	public String[] delete(String tableName, String id) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("tableName", tableName);
		map1.put("id", "'" + id + "'");
		int res = dao.deleteByPrimaryKey(map1);
		if (res > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
