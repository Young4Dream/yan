/**
 * 
 */
package com.tstar.ocs.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.SidFee;
import com.tstar.ocs.service.SidFeeService;

/**
 * @author zhumengfeng
 *
 */
public class SidFeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SidFeeService service;
	
	private String id;
	private SidFee obj;
	private List<SidFee> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SidFee obj) { this.obj = obj; }
	public SidFee getObj() { return obj; }
	
	public void setLst(List<SidFee> lst) { this.lst = lst; }
	public List<SidFee> getLst() { return lst; }
	
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
	
	public String selectByPage() {
		lst = service.selectByPage(start, length);
		recordsTotal = service.countAll();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findAll() {
		lst = service.selectAll();
		recordsTotal = service.countAll();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String selectOpFee() {
		lst = service.selectOpFee(id);
		return "getRecords";
	}
	
	public String selectOpFeeByName() {
		lst = service.selectOpFeeByName(obj.getName());
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
