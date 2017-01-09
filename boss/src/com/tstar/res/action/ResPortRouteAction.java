/**
 * 
 */
package com.tstar.res.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResUserPort;
import com.tstar.res.service.ResUserPortService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class ResPortRouteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResUserPortService service;
	
	private String id;
	private ResUserPort obj;
	private List<ResUserPort> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResUserPort obj) { this.obj = obj; }
	public ResUserPort getObj() { return obj; }
	
	public void setLst(List<ResUserPort> lst) { this.lst = lst; }
	public List<ResUserPort> getLst() { return lst; }
	
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
		HttpServletRequest request= ServletActionContext.getRequest();
		String id = request.getParameter("id");
		ActionContext.getContext().getSession().put("portRouteUserId", id);
		return "showHomePage";
	}
	
	public String findByUserId() {
		if (StringUtil.isEmpty(id)) {
			lst = new ArrayList<ResUserPort>();
		} else {
			lst = service.selectByUserId(id);
		}
		return "getRecords";
	}
	
	public String insert() {
		String[] r = service.insert(obj);
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
