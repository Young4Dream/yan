/**
 * 
 */
package com.tstar.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.crm.model.CrmUser;
import com.tstar.crm.service.CrmUserService;

/**
 * @author zhumengfeng
 *
 */
public class CrmUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CrmUserService service;
	
	private String id;
	private CrmUser obj;
	private Map<String, Object> userFullInfo;
	private List<CrmUser> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(CrmUser obj) { this.obj = obj; }
	public CrmUser getObj() { return obj; }
	
	public void setLst(List<CrmUser> lst) { this.lst = lst; }
	public List<CrmUser> getLst() { return lst; }
	
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
	
	public String findById() {
		obj = service.selectByPrimaryKey(id);
		return "getRecords";
	}
	
	public String findFullInfoById() {
		userFullInfo = service.selectFullInfoById(id);
		return "getRecords";
	}
	
	public String findFullInfoByBusinessKey() {
		userFullInfo = service.selectFullInfoByBusinessKey(id);
		return "getRecords";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (obj.getBusinessType() != null && !"".equals(obj.getBusinessType())) {
				map.put("businessType", obj.getBusinessType());
			}
			if (obj.getFullText() != null && !"".equals(obj.getFullText())) {
				map.put("fullText", obj.getFullText());
			}
			if (obj.getStatus() != null) {
				map.put("status", obj.getStatus());
			}
			if (obj.getBeginStatus() != null) {
				map.put("beginStatus", obj.getBeginStatus());
			}
			if (obj.getEndStatus() != null) {
				map.put("endStatus", obj.getEndStatus());
			}
			
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.selectByPage(map);
		return "getRecords";
	}
	public Map<String, Object> getUserFullInfo() {
		return userFullInfo;
	}
	public void setUserFullInfo(Map<String, Object> userFullInfo) {
		this.userFullInfo = userFullInfo;
	}
	
}
