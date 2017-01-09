/**
 * 
 */
package com.tstar.res.action;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResAddress;
import com.tstar.res.service.ResAddressService;

/**
 * @author zhumengfeng
 *
 */
public class ResAddressAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResAddressService service;
	
	private String id;
	private ResAddress obj;
	private List<ResAddress> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	private JSONArray ztree;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResAddress obj) { this.obj = obj; }
	public ResAddress getObj() { return obj; }
	
	public void setLst(List<ResAddress> lst) { this.lst = lst; }
	public List<ResAddress> getLst() { return lst; }
	
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
	
	public String findAll() {
		lst = service.findAll();
		recordsTotal = lst.size();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findAll2Tree() {
		ztree = service.findAll2Tree();
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
	public JSONArray getZtree() {
		return ztree;
	}
	public void setZtree(JSONArray ztree) {
		this.ztree = ztree;
	}
	
}
