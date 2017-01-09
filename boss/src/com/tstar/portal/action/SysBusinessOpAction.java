/**
 * 
 */
package com.tstar.portal.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.SysBusinessOp;
import com.tstar.portal.service.SysBusinessOpService;

/**
 * @author zhumengfeng
 *
 */
public class SysBusinessOpAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SysBusinessOpService service;
	
	private String id;
	private SysBusinessOp obj;
	private List<SysBusinessOp> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SysBusinessOp obj) { this.obj = obj; }
	public SysBusinessOp getObj() { return obj; }
	
	public void setLst(List<SysBusinessOp> lst) { this.lst = lst; }
	public List<SysBusinessOp> getLst() { return lst; }
	
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
		recordsTotal = service.countAll();
		recordsFiltered = recordsTotal;
		lst = service.selectByPage(start, length);
		return "getRecords";
	}
	
	public String update() {
		String[] r = service.update(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
