package com.tstar.ocs.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.SidPricePlan;
import com.tstar.ocs.service.SidPricePlanService;

public class SidPricePlanAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SidPricePlanService service;
	
	private String id;
	private SidPricePlan obj;
	private List<SidPricePlan> lst;
	private String resNum;
	private String res;
	private Map<String, Object> criteria;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SidPricePlan obj) { this.obj = obj; }
	public SidPricePlan getObj() { return obj; }
	
	public void setLst(List<SidPricePlan> lst) { this.lst = lst; }
	public List<SidPricePlan> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// 查询条件
	public Map<String, Object> getCriteria() { return criteria; }
	public void setCriteria(Map<String, Object> criteria) { this.criteria = criteria; }
	
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
	
	public String selectByCriteria() {
		if (criteria == null) criteria = new HashMap<String, Object>();
		String[] arr = (String[])criteria.get("name");
		if (arr != null) criteria.put("name", arr[0]);
		arr = (String[])criteria.get("planType");
		if (arr != null) criteria.put("planType", Integer.parseInt(arr[0]));
		arr = (String[])criteria.get("status");
		if (arr != null) criteria.put("status", Integer.parseInt(arr[0]));
		recordsTotal = service.countByCriteria(criteria);
		recordsFiltered = recordsTotal;
		criteria.put("start", start);
		criteria.put("length", length);
		lst = service.selectByCriteria(criteria);
		return "getRecords";
	}
	
	public String selectReleasedPublicPlan() {
		lst = service.selectReleasedPublicPlan();
		return "getRecords";
	}
	
	public String findOrderableByBusiness() {
		lst = service.selectOrderableByBusiness(obj.getBearable());
		recordsTotal = lst.size();
		recordsFiltered = recordsTotal;
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
