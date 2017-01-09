package com.tstar.ocs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.SidVoiceConfigItem;
import com.tstar.ocs.service.SidVoiceConfigItemService;

public class SidVoiceConfigItemAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SidVoiceConfigItemService service;
	
	private String id;
	private String configId;
	private SidVoiceConfigItem obj;
	private List<SidVoiceConfigItem> lst;
	private String resNum;
	private String res;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setConfigId(String configId) { this.configId = configId; }
	public String getConfigId() { return configId; }
	
	public void setObj(SidVoiceConfigItem obj) { this.obj = obj; }
	public SidVoiceConfigItem getObj() { return obj; }
	
	public void setLst(List<SidVoiceConfigItem> lst) { this.lst = lst; }
	public List<SidVoiceConfigItem> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// DataTable分页需要
	public int getRecordsTotal() { return lst == null ? 0 : lst.size(); }
	public int getRecordsFiltered() { return lst == null ? 0 : lst.size(); }
	
	public String findByConfigId() {
		System.out.println("******************************************************************");
		System.out.println("configId=" + configId);
		if (configId == null || "".equals(configId)) {
			lst = new ArrayList<SidVoiceConfigItem>();
		} else {
			lst = service.selectByConfigId(configId);
		}
		return "getRecords";
	}
	
	public String insert() {
		String[] r = service.insert(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String update() {
		String[] r = service.update(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String delete() {
		String[] r = service.delete(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
}
