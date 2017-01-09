package com.tstar.portal.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.Dept;
import com.tstar.portal.model.ResultMap;
import com.tstar.portal.service.DeptService;

public class DeptAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Dept obj;
	
	private List<ResultMap> lst = new ArrayList<ResultMap>();
	
	private String resNum;
	private String res;
	private int recordCount;
	private int filterCount;
	
	@Resource
	private DeptService service;

	public String goToDeptPage()
	{
		return "showHomePage";
	}
	
	public String findAll() {
		lst = service.getAllDepts();
		recordCount = lst.size();
		filterCount = lst.size();
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
		return "getRecords";
	}
	
	public String deleteByCode() {
		String[] r = service.deleteByCode(obj.getDeptNo());
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public void setObj(Dept obj) { this.obj = obj; }
	public Dept getObj() { return obj; }
	
	public void setLst(List<ResultMap> lst) { this.lst = lst; }
	public List<ResultMap> getLst() { return lst; }
	
	public void setRecordCount(int recordCount) { this.recordCount  = recordCount; }
	public int getRecordCount() { return recordCount; }
	
	public void setFilterCount(int filterCount) { this.filterCount = filterCount; }
	public int getFilterCount() { return filterCount; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
}
