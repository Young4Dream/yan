package com.tstar.portal.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.User;
import com.tstar.portal.service.UserService;
import com.tstar.util.StringUtil;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserService service;
	
	private String id;
	private User obj;
	private List<User> lst;
	private String resNum;
	private String res;
	private int start;
	private int length;
	private int recordsTotal;
	private int recordsFiltered;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setObj(User obj) { this.obj = obj; }
	public User getObj() { return obj; }
	
	public void setLst(List<User> lst) { this.lst = lst; }
	public List<User> getLst() { return lst; }
	
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
	
	public String goToUserPage() {
		return "showHomePage";
	}
	
	public String findByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj != null) {
			if (!StringUtil.isEmpty(obj.getUserName())) {
				map.put("userName", obj.getUserName());
			}
			if (!StringUtil.isEmpty(obj.getUserAlias())) {
				map.put("userAlias", obj.getUserAlias());
			}
		}
		recordsTotal = service.countByCriteria(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		lst = service.findByPage(map);
		return "getRecords";
	}
	
	public String findByRoleName() {
		lst = service.selectByRole(obj.getRoleId());
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
