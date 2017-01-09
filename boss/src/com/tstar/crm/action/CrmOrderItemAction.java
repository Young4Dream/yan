/**
 * 
 */
package com.tstar.crm.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.CrmOrderItem;
import com.tstar.crm.service.CrmOrderItemService;

/**
 * @author zhumengfeng
 *
 */
public class CrmOrderItemAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CrmOrderItemService service;
	
	private CrmOrderItem obj;
	private String resNum;
	private String res;
	
	public void setObj(CrmOrderItem obj) { this.obj = obj; }
	public CrmOrderItem getObj() { return obj; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	
	public String insert() {
		String[] r = service.insert(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String cancel() {
		String[] r = service.cancel(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
