/**
 * 
 */
package com.tstar.res.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResDevice;
import com.tstar.res.service.ResDeviceService;

/**
 * @author zhumengfeng
 *
 */
public class ResDeviceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResDeviceService service;
	
	private String id;
	private ResDevice obj;
	private List<ResDevice> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResDevice obj) { this.obj = obj; }
	public ResDevice getObj() { return obj; }
	
	public void setLst(List<ResDevice> lst) { this.lst = lst; }
	public List<ResDevice> getLst() { return lst; }
	
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
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (obj.getDeviceCode() != null && !"".equals(obj.getDeviceCode())) {
				map.put("deviceCode", obj.getDeviceCode());
			}
			if (obj.getName() != null && !"".equals(obj.getName())) {
				map.put("name", obj.getName());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
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
	
	public String generatePort() {
		String[] r = service.generatePort(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
}
