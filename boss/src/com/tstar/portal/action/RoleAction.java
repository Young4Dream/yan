package com.tstar.portal.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.ResultMap;
import com.tstar.portal.model.Role;
import com.tstar.portal.service.RoleService;
import com.tstar.util.StringUtil;

public class RoleAction extends ActionSupport{

	/**
	 * 系统角色/菜单权限设置
	 * @author lixm	
	 * 
	 * 2015-5-6 14:02
	 */
	private static final long serialVersionUID = 1L;
	
	private Role role = new Role();
	
	private List<ResultMap> aaData = new ArrayList<ResultMap>();
	private JSONArray jsArray = new JSONArray();
	String id ;
	private String res;
	private String resNum;
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	
	private String menuChange;
	private String roleId;

	@Resource
	private RoleService roleService;
	
	public String goToRolePage(){
		return "rolePage";
	}
	
	public String allRole(){
		Map<String, Object> map = new HashMap<String, Object>();
		if (role != null) {
			if (!StringUtil.isEmpty(role.getRoleName())) {
				map.put("roleName", role.getRoleName());
			}
		}
		recordsTotal = roleService.countByName(map);
		recordsFiltered = recordsTotal;
		map.put("start", start);
		map.put("length", length);
		aaData = roleService.findRoleByPage(map);
		return "allRole";
	}
	
	public String insert(){
		String[] r = roleService.insert(role);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String update(){
		String[] r = roleService.updateByPrimaryKey(role);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String delete(){
		String[] r = roleService.deleteByPrimaryKey(id);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String check(){
		//jsArray = roleService.menuJson(roleService.checkedId(id));
		jsArray = roleService.menuJson(id);
		return "checked";
	}
	
	public String menuChange(){
		String[] r = roleService.menuUpdateByMenuId(roleId, menuChange);
		resNum = r[0];
		res = r[1];
		return check();
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<ResultMap> getAaData() {
		return aaData;
	}
	public void setAaData(List<ResultMap> aaData) {
		this.aaData = aaData;
	}
	public JSONArray getJsArray() {
		return jsArray;
	}
	public void setJsArray(JSONArray jsArray) {
		this.jsArray = jsArray;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}

	public void setMenuChange(String menuChange) {
		this.menuChange = menuChange;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public String getId() {
		return id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuChange() {
		return menuChange;
	}

}
