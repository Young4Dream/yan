/**
 * 
 */
package com.tstar.portal.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.SysNotice;
import com.tstar.portal.service.SysNoticeService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class SysNoticeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SysNoticeService service;
	
	private String id;
	private SysNotice obj;
	private List<SysNotice> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SysNotice obj) { this.obj = obj; }
	public SysNotice getObj() { return obj; }
	
	public void setLst(List<SysNotice> lst) { this.lst = lst; }
	public List<SysNotice> getLst() { return lst; }
	
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
			if (obj.getStatus() != null) {
				map.put("status", obj.getStatus());
			}
			if (!StringUtil.isEmpty(obj.getLevel())) {
				map.put("level", obj.getLevel());
			}
			if (!StringUtil.isEmpty(obj.getSubject())) {
				map.put("subject", obj.getSubject());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
		return "getRecords";
	}
	
	public String countNewNotice() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 1);
		recordsTotal = service.countByCriteria(map);
		return "getRecords";
	}
	
	public String findTop10() {
		lst = service.findTop10();
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
