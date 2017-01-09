package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.SystemConfService;

public class SystemConfAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int saveTime;
	private String  systemIp;
	private String  gwIp;
	private List<ResultMap> systemConf = new ArrayList<ResultMap>();
	private List<ResultMap> sysip = new ArrayList<ResultMap>();
	private String res;
	private String resNum;
	
	@Resource
	private SystemConfService sysConfService;
	
	
	
	public String goToSystemConfPage(){
		return "systemConfPage";
	}
	
	public String selectSysConf(){
		systemConf = sysConfService.selectSystemConf();
		return "systemConf";
	}
	
	public String updateSysConf(){
	    String[] r = sysConfService.updateSystemConf(saveTime, systemIp, gwIp);
		resNum = r[0];
		res = r[1];
		return "systemConf";
	}
	
	public String selectSysIp(){
		sysip = sysConfService.selectSystemIp();
		return "systemConf";
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

	public String getSystemIp() {
		return systemIp;
	}

	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}

	public int getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(int saveTime) {
		this.saveTime = saveTime;
	}

	public List<ResultMap> getSystemConf() {
		return systemConf;
	}

	public void setSystemConf(List<ResultMap> systemConf) {
		this.systemConf = systemConf;
	}

	public List<ResultMap> getSysip() {
		return sysip;
	}

	public void setSysip(List<ResultMap> sysip) {
		this.sysip = sysip;
	}

    public String getGwIp() {
        return gwIp;
    }

    public void setGwIp(String gwIp) {
        this.gwIp = gwIp;
    }
	
	
	
	

}
