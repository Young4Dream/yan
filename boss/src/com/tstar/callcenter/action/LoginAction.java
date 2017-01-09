package com.tstar.callcenter.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.service.LoginService;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String phone;
	private String ip;
	private String gwIp;
	private String res;
	private String resNum;
	private long isAdmin;
	private String userId;
	
	
	@Resource
	private LoginService loginService;
	
	
	public String loginPage(){
		return "loginPage";
	}
	/**
	 * 用户登录
	 * */
	public String login(){
		String[] r =loginService.login(userName, password, phone, ip, gwIp, isAdmin);
		resNum = r[0];
		res = r[1];
//		String ret = "";
//		if(!resNum.equals("1")){
//			ret = "fail";
//		}else{
//			if(isAdmin.equals("0")){
//				ret = "success";
//			}else if(isAdmin.equals("1")){
//				ret = "adminSuccess";
//			}
//		}
//		return ret;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(long isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    public String getGwIp() {
        return gwIp;
    }
    public void setGwIp(String gwIp) {
        this.gwIp = gwIp;
    }

	
	
}
