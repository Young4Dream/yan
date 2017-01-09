package com.tstar.portal.service;

import java.util.List;
import java.util.Map;

import com.tstar.portal.model.User;

public interface UserService {
	int countByCriteria(Map<String, Object> map);
	
	List<User> findByPage(Map<String, Object> map);
	
	List<User> selectByRole(String roleName);
	
	String[] insert(User obj);
	
	String[] update(User obj);
	
	String[] delete(String id);
	
}
