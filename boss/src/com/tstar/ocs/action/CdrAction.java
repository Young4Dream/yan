package com.tstar.ocs.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.service.CdrService;
import com.tstar.util.DateUtil;
import com.tstar.util.StringUtil;

public class CdrAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CdrService service;
	
	private String id;
	private Cdr obj;
	private List<Cdr> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(Cdr obj) { this.obj = obj; }
	public Cdr getObj() { return obj; }
	
	public void setLst(List<Cdr> lst) { this.lst = lst; }
	public List<Cdr> getLst() { return lst; }
	
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
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.getCaller())) {
				map.put("caller", obj.getCaller());
			}
			if (!StringUtil.isEmpty(crStartTime)) {
				try { map.put("startTime", DateUtil.parse1(crStartTime)); } catch (Exception e) {}
			}
			if (!StringUtil.isEmpty(crEndTime)) {
				try { map.put("endTime", DateUtil.parse1(crEndTime)); } catch (Exception e) {}
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	
	
	private String crStartTime;
	private String crEndTime;

	public String getCrStartTime() {
		return crStartTime;
	}
	public void setCrStartTime(String crStartTime) {
		this.crStartTime = crStartTime;
	}
	public String getCrEndTime() {
		return crEndTime;
	}
	public void setCrEndTime(String crEndTime) {
		this.crEndTime = crEndTime;
	}
}
