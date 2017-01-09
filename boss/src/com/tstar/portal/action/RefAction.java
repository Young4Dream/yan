/**
 * 
 */
package com.tstar.portal.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.service.RefService;

/**
 * @author zhumengfeng
 *
 */
public class RefAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RefService service;
	
	private String id;
	private String tableName;
	private Map<String, String> obj;
	private List<Map<String, String>> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setTableName(String tableName) { this.tableName = tableName; }
	public String getTableName() { return tableName; }
	
	public void setObj(Map<String, String> obj) { this.obj = obj; }
	public Map<String, String> getObj() { return obj; }
	
	public void setLst(List<Map<String, String>> lst) { this.lst = lst; }
	public List<Map<String, String>> getLst() { return lst; }
	
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
		lst = service.selectAll(tableName);
		recordsTotal = lst.size();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String insert() {
		String[] r = service.insert(tableName, obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String update() {
		String[] r = service.update(tableName, obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String delete() {
		String[] r = service.delete(tableName, id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
