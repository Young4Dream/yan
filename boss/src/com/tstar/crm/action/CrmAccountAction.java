/**
 * 
 */
package com.tstar.crm.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.CrmAccount;
import com.tstar.crm.service.CrmAccountService;

/**
 * @author zhumengfeng
 *
 */
public class CrmAccountAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CrmAccountService service;
	
	private String id;
	private CrmAccount obj;
	private List<CrmAccount> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(CrmAccount obj) { this.obj = obj; }
	public CrmAccount getObj() { return obj; }
	
	public void setLst(List<CrmAccount> lst) { this.lst = lst; }
	public List<CrmAccount> getLst() { return lst; }
	
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
	
	public String findByCustomerId() {
		obj = service.selectByCustomerId(id);
		return "getRecords";
	}
		
}
