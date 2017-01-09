/**
 * 
 */
package com.tstar.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.service.OcsAccountLogService;
import com.tstar.util.DateUtil;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class OcsAccountLogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OcsAccountLogService service;
	
	
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
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.get("opType"))) {
				map.put("opType", obj.get("opType"));
			}
			if (!StringUtil.isEmpty(obj.get("fullText"))) {
				map.put("fullText", obj.get("fullText"));
			}
			if (!StringUtil.isEmpty(obj.get("oper"))) {
				map.put("oper", Integer.parseInt(obj.get("oper")));
			}
			if (!StringUtil.isEmpty(obj.get("startTime"))) {
				try { map.put("startTime", DateUtil.parse1(obj.get("startTime"))); } catch (Exception e) {}
			}
			if (!StringUtil.isEmpty(obj.get("endTime"))) {
				try { map.put("endTime", DateUtil.parse1(obj.get("endTime"))); } catch (Exception e) {}
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
		return "getRecords";
	}
	
}
