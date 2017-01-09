/**
 * 
 */
package com.tstar.crm.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.JobOpWorkload;
import com.tstar.crm.service.JobOpWorkloadService;

/**
 * @author zhumengfeng
 *
 */
public class JobOpWorkloadAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Resource
    JobOpWorkloadService service;
	
	private String id;
	private JobOpWorkload obj;
	private List<JobOpWorkload> lst;
	
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(JobOpWorkload obj) { this.obj = obj; }
	public JobOpWorkload getObj() { return obj; }
	
	public void setLst(List<JobOpWorkload> lst) { this.lst = lst; }
	public List<JobOpWorkload> getLst() { return lst; }
	
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
	
	public String findByFormId() {
		lst = service.findByFormId(obj.getFormId());
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
	
	public String delete() {
		String[] r = service.delete(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
		
}