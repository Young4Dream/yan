package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.UserMapper;
import com.tstar.portal.model.User;
import com.tstar.portal.service.UserService;
import com.tstar.util.UUID;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper dao;
	
	public int countByCriteria(Map<String, Object> map) {
		return dao.countByCriteria(map);
	}
	
	public List<User> findByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}
	
	public List<User> selectByRole(String roleName) {
		return dao.selectByRole(roleName);
	}

	public String[] insert(User obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int result = dao.insert(obj);
		if (result > 0){
			return new String[]{"0", "添加成功!"};
		} else {
			return new String[]{"1", "添加失败!"};
		}
	}

	public String[] update(User obj) {
		obj.setUpdateTime(new Date());
		int result = dao.updateByPrimaryKeySelective(obj);
		if( result > 0){
			return new String[]{"0", "修改成功!"};
		}else{
			return new String[]{"1", "修改失败!"};
		}
	}


	public String[] delete(String id) {
		int result = dao.deleteByPrimaryKey(id);
		if (result > 0){
			return new String[]{"0", "删除成功!"};
		}else{
			return new String[]{"1", "删除失败!"};
		}
	}

	
}
