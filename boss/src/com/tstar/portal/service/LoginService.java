package com.tstar.portal.service;

public interface LoginService {
	String[] login(String userName,String password);
	public void logout();
}
