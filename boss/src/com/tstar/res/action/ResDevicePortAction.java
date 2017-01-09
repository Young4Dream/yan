/**
 * 
 */
package com.tstar.res.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResDevicePort;
import com.tstar.res.service.ResDevicePortService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class ResDevicePortAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResDevicePortService service;
	
	private String id;
	private ResDevicePort obj;
	private List<ResDevicePort> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResDevicePort obj) { this.obj = obj; }
	public ResDevicePort getObj() { return obj; }
	
	public void setLst(List<ResDevicePort> lst) { this.lst = lst; }
	public List<ResDevicePort> getLst() { return lst; }
	
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
			if (obj.getPortCode() != null && !"".equals(obj.getPortCode())) {
				map.put("portCode", obj.getPortCode());
			}
			if (obj.getStatus() != null && !"".equals(obj.getStatus())) {
				map.put("portCode", obj.getStatus());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	
	public String findUsable() {
		if (obj == null || StringUtil.isEmpty(obj.getBearing())) {
			lst = new ArrayList<ResDevicePort>();
			return "getRecords";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bearing", obj.getBearing());
		if (obj != null) {
			if (obj.getDeviceCode() != null && !"".equals(obj.getDeviceCode())) {
				map.put("deviceCode", obj.getDeviceCode());
			}
			if (obj.getPortCode() != null && !"".equals(obj.getPortCode())) {
				map.put("portCode", obj.getPortCode());
			}
		}
		recordsTotal = service.countUsable(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectUsable(map);
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
