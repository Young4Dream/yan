package com.tstar.ocs.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.service.CdrLogService;

public class CdrLogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CdrLogService service;
	
	private String id;
	private CdrLog obj;
	private List<CdrLog> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(CdrLog obj) { this.obj = obj; }
	public CdrLog getObj() { return obj; }
	
	public void setLst(List<CdrLog> lst) { this.lst = lst; }
	public List<CdrLog> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// DataTable分页需要
	public int getRecordsTotal() { return recordsTotal; }
	public int getRecordsFiltered() { return recordsFiltered; }
	public int getStart() { return start; }
	public void setStart(int start) { this.start = start; }
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	public String goToPage() {
		return "showHomePage";
	}
	
	public String selectByPage() {
		lst = service.selectByPage(start, length);
		recordsTotal = service.countAll();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
}
