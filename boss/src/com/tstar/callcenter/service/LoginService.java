package com.tstar.callcenter.service;

public interface LoginService {
	
	String[] login(String userName,String password,String phone,String ip, String gwIp, long admin);
	
	public void logout();
	
	public int isLogin();
	
	public String getLoginUserName();

}
