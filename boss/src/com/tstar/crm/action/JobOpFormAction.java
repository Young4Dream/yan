/**
 * 
 */
package com.tstar.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.JobOpForm;
import com.tstar.crm.service.JobOpFormService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class JobOpFormAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Resource
    JobOpFormService service;
	
	private String id;
	private JobOpForm obj;
	private List<JobOpForm> lst;
	
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(JobOpForm obj) { this.obj = obj; }
	public JobOpForm getObj() { return obj; }
	
	public void setLst(List<JobOpForm> lst) { this.lst = lst; }
	public List<JobOpForm> getLst() { return lst; }
	
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
	
	public String edit() {
		return "showDetailPage";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.getFormType())) {
				map.put("formType", obj.getFormType());
			}
			if (!StringUtil.isEmpty(obj.getStatus())) {
				map.put("status", obj.getStatus());
			}
			if (!StringUtil.isEmpty(obj.getJobNo())) {
				map.put("jobNo", obj.getJobNo());
			}
			if (!StringUtil.isEmpty(obj.getAssignee())) {
				map.put("assignee", obj.getAssignee());
			}
		}
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String generate() {
		obj = service.generate(id);
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
		
}