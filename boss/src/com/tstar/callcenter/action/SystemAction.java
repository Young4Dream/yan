package com.tstar.callcenter.action;

import com.opensymphony.xwork2.ActionSupport;

public class SystemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 首页框架
	public String goToIndexPage()
	{
		return "indexPage";
	}
	
	public String goToAdminPage()
	{
		return "adminPage";
	}


}
