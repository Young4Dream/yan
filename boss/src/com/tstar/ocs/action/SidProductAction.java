/**
 * 
 */
package com.tstar.ocs.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.SidProduct;
import com.tstar.ocs.service.SidProductService;

/**
 * @author zhumengfeng
 *
 */
public class SidProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SidProductService service;
	
	private String id;
	private SidProduct obj;
	private List<SidProduct> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SidProduct obj) { this.obj = obj; }
	public SidProduct getObj() { return obj; }
	
	public void setLst(List<SidProduct> lst) { this.lst = lst; }
	public List<SidProduct> getLst() { return lst; }
	
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
	
	public String selectRoot() {
		lst = service.selectRoot();
		return "getRecords";
	}
	
	public String selectChildren() {
		lst = service.selectChildren();
		return "getRecords";
	}
	
	public String selectChildrenByPage() {
		lst = service.selectChildrenByPage(obj.getParentId(), start, length);
		recordsTotal = service.countChildren(obj.getParentId());
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
