package com.tstar.portal.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.util.DateUtil;

public class SystemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String parm;
	
	public String getParm() {
		return parm;
	}

	public void setParm(String parm) {
		this.parm = parm;
	}

	// 首页框架
	public String gotoPortal()
	{
		return "portalPage";
	}
	
	public String goToDashboardPage() {
		return "dashboardPage";
	}
	
	// 
	public String nextDay() {
		try {
			Date dt = DateUtil.parse1(parm);
			dt = DateUtil.add(dt, "DAY", 1);
			parm = DateUtil.formatDate(dt);
		} catch (Exception e) {
			parm = "";
		}
		return "getRecords";
	}
	
}
