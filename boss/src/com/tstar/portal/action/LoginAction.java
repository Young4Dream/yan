package com.tstar.portal.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.service.LoginService;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String res;
	private String resNum;
	private String id;
	
	@Resource
	private LoginService loginService;
	
	
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * 用户登录
	 * */
	public String login(){
		String[] r = loginService.login(userName, password);
		resNum = r[0];
		res = r[1];
		return "login";
	}
	
	/**
	 * 用户注销登录
	 * */
	public String logout()
	{
		loginService.logout();
		
		return "loginPage";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getResNum() {
		return resNum;
	}

	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
