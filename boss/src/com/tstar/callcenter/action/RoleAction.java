package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.autogenerate.RoleInfo;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.RoleService;

public class RoleAction extends ActionSupport{

	/**
	 * 系统角色/菜单权限设置
	 * @author lixm	
	 * 
	 * 2015-5-6 14:02
	 */
	private static final long serialVersionUID = 1L;
	
	private RoleInfo roleInfo = new RoleInfo();
	
	private List<ResultMap> aaData = new ArrayList<ResultMap>();
	private JSONArray jsArray = new JSONArray();
	long roleId ;
	private String res;
	private String resNum;
	private String menuChange;
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	

	@Resource
	private RoleService roleService;
	
	public String goToRolepage(){
		return "rolePage";
	}
	public String allRole(){
		aaData = roleService.findRoleByPage(roleInfo,start,length);
		recordsTotal = roleService.findRoleByCount(roleInfo);
		recordsFiltered = recordsTotal;
		return "allRole";
	}
	
	public String insert(){
		String[] r = roleService.insert(roleInfo);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String update(){
		String[] r = roleService.updateByPrimaryKey(roleInfo);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String delete(){
		String[] r = roleService.deleteByPrimaryKey(roleId);
		resNum = r[0];
		res = r[1];
		return "allRole";
	}
	
	public String check(){
		jsArray = roleService.menuJson(roleService.checkedId(roleId));
		return "checked";
	}
	
	public String menuChange(){
		String[] r = roleService.menuUpdateByMenuId(roleId,menuChange);
		resNum = r[0];
		res = r[1];
		return check();
	}
	
	
	
	
	
	
	
	
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
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
	public void setRoleId(long roleId) {
		this.roleId = roleId;
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

	
	







	
	


	

	
	


	
	
	
	

}
