/**
 * 
 */
package com.tstar.activiti.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.activiti.service.OpTaskService;

/**
 * @author zhumengfeng
 *
 */
public class OpTaskAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
    @Resource
    OpTaskService service;
	
	private String id;
	private Map<String, String> obj;
	private List<Map<String, Object>> lst;
	
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(Map<String, String> obj) { this.obj = obj; }
	public Map<String, String> getObj() { return obj; }
	
	public void setLst(List<Map<String, Object>> lst) { this.lst = lst; }
	public List<Map<String, Object>> getLst() { return lst; }
	
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
	
	public String goToMonitorPage() {
		return "showMonitorPage";
	}
	
	public String goToHistoryPage() {
		return "showHistoryPage";
	}
	
	public String findByPage() {
		lst = service.findByPage(id, start, length);
		recordsTotal = service.countAll(id);
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findRunningByPage() {
		lst = service.findRunningByPage(start, length);
		recordsTotal = service.countRunning();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findFinishedByPage() {
		lst = service.findFinishedByPage(start, length);
		recordsTotal = service.countRunning();
		recordsFiltered = recordsTotal;
		return "getRecords";
	}
	
	public String findNewTaskCount() {
		recordsTotal = service.countAll(id);
		return "getRecords";
	}
	
	public String findTaskFormProperties() {
		lst = service.getTaskFormProperties(id);
		return "getRecords";
	}
	
	public String claim() {
		String[] r = service.claim(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String handle() {
		String[] r = service.handle(id, obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
