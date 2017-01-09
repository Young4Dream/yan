package com.tstar.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.Customer;
import com.tstar.crm.service.CustomerService;

public class CustomerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CustomerService service;
	
	private String id;
	private Customer obj;
	private List<Customer> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(Customer obj) { this.obj = obj; }
	public Customer getObj() { return obj; }
	
	public void setLst(List<Customer> lst) { this.lst = lst; }
	public List<Customer> getLst() { return lst; }
	
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
	
	public String findById() {
		obj = service.selectByPrimaryKey(id);
		return "getRecords";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (obj.getCustomerNo() != null && !"".equals(obj.getCustomerNo())) {
				map.put("customerNo", obj.getCustomerNo());
			}
			if (obj.getName() != null && !"".equals(obj.getName())) {
				map.put("name", obj.getName());
			}
			if (obj.getFullText() != null && !"".equals(obj.getFullText())) {
				map.put("fullText", obj.getFullText());
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
	
}
