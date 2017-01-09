/**
 * 
 */
package com.tstar.res.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.res.model.ResAcc;
import com.tstar.res.service.ResAccService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class ResAccAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private ResAccService service;
	
	private String id;
	private ResAcc obj;
	private List<ResAcc> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(ResAcc obj) { this.obj = obj; }
	public ResAcc getObj() { return obj; }
	
	public void setLst(List<ResAcc> lst) { this.lst = lst; }
	public List<ResAcc> getLst() { return lst; }
	
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
			if (!StringUtil.isEmpty(obj.getAcc())) {
				map.put("acc", obj.getAcc());
			}
			if (!StringUtil.isEmpty(obj.getBearable())) {
				map.put("bearable", obj.getBearable());
			}
			if (obj.getStatus() != null) {
				map.put("status", obj.getStatus());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	
	public String findTopUsable() {
		id = service.findTopUsable(obj.getAcc(), obj.getBearable());
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
	
	public String lockAcc() {
		String[] r = service.lockAcc(obj.getAcc(), new Date());
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
}
