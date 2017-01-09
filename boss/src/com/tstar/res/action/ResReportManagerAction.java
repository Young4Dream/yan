/**
 * 
 */
package com.tstar.res.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResReport;
import com.tstar.res.service.ResReportService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class ResReportManagerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResReportService service;
	
	private String id;
	private ResReport obj;
	private List<ResReport> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResReport obj) { this.obj = obj; }
	public ResReport getObj() { return obj; }
	
	public void setLst(List<ResReport> lst) { this.lst = lst; }
	public List<ResReport> getLst() { return lst; }
	
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
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.getReportKey())) {
				map.put("reportKey", obj.getReportKey());
			}
			if (!StringUtil.isEmpty(obj.getReportName())) {
				map.put("reportName", obj.getReportName());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
		return "getRecords";
	}
	
	public String findByKey() {
		obj = service.findByKey(id);
		return "getRecords";
		//com.fr.report.cell.cellattr.core.group.FunctionGrouper obj;
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
