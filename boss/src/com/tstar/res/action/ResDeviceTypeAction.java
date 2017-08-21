/**
 * 
 */
package com.tstar.res.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResDeviceType;
import com.tstar.res.service.ResDeviceTypeService;

/**
 * @author zhumengfeng
 *
 */
public class ResDeviceTypeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResDeviceTypeService service;
	
	private String id;
	private ResDeviceType obj;
	private List<ResDeviceType> lst;
	private String resNum;
	private String res;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResDeviceType obj) { this.obj = obj; }
	public ResDeviceType getObj() { return obj; }
	
	public void setLst(List<ResDeviceType> lst) { this.lst = lst; }
	public List<ResDeviceType> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// DataTable分页需要
	public int getRecordsTotal() { return lst == null ? 0 : lst.size(); }
	public int getRecordsFiltered() { return lst == null ? 0 : lst.size(); }
	
	public String goToPage() {
		return "showHomePage";
	}
	
	public String findAll() {
		lst = service.selectAll();
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