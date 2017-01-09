/**
 * 
 */
package com.tstar.portal.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.SysSmsOutbox;
import com.tstar.portal.service.SysSmsOutboxService;
import com.tstar.util.StringUtil;

/**
 * @author zhumengfeng
 *
 */
public class SysSmsOutboxAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SysSmsOutboxService service;
	
	private String id;
	private SysSmsOutbox obj;
	private List<SysSmsOutbox> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(SysSmsOutbox obj) { this.obj = obj; }
	public SysSmsOutbox getObj() { return obj; }
	
	public void setLst(List<SysSmsOutbox> lst) { this.lst = lst; }
	public List<SysSmsOutbox> getLst() { return lst; }
	
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
		map.put("sender", obj.getSender());
		if (obj.getStatus() != null) {
			map.put("status", obj.getStatus());
		}
		if (!StringUtil.isEmpty(obj.getRecipient())) {
			map.put("recipient", obj.getRecipient());
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
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
	
	public String send() {
		String[] r;
		if (StringUtil.isEmpty(id)) {
			r = service.send(obj);
		} else {
			r = service.send(id);
		}
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
