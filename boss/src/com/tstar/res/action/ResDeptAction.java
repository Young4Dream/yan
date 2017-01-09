/**
 * 
 */
package com.tstar.res.action;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResDept;
import com.tstar.res.service.ResDeptService;

/**
 * @author zhumengfeng
 *
 */
public class ResDeptAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResDeptService service;
	
	private String id;
	private ResDept obj;
	private List<ResDept> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	private JSONArray ztree;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResDept obj) { this.obj = obj; }
	public ResDept getObj() { return obj; }
	
	public void setLst(List<ResDept> lst) { this.lst = lst; }
	public List<ResDept> getLst() { return lst; }
	
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
	
	public String selectRoot() {
		lst = service.selectRoot();
		return "getRecords";
	}
	
	public String selectChildren() {
		lst = service.selectChildren(obj.getParentId());
		return "getRecords";
	}
	
	public String findAll2Tree() {
		ztree = service.findAll2Tree();
		return "getRecords";
	}
	
	public String findAll2Tree4Choosed() {
		ztree = service.findAll2Tree4Choosed();
		return "getRecords";
	}
	
	public String nextDeptCode() {
		id = service.nextDeptCode(id);
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
	
	public String deleteByCode() {
		String[] r = service.deleteByCode(obj.getDeptCode());
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	public JSONArray getZtree() {
		return ztree;
	}
	public void setZtree(JSONArray ztree) {
		this.ztree = ztree;
	}
	
}
