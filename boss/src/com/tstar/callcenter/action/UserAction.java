package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.autogenerate.UserInfo;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.UserService;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private UserInfo userInfo = new UserInfo();
	private List<ResultMap> userList = new ArrayList<ResultMap>();
	private List<ResultMap> roleSelect = new ArrayList<ResultMap>();

	private String res;
	private String resNum;
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	private String oldPw;
	private String newPw1;
	private String newPw2;
	
	
	@Resource
	UserService userService;

	public String goToUserPage(){
		
		return "userPage";
	}
	
	public String userList(){
		userList = userService.selectUserByPage(userInfo, start, length);
		recordsTotal = userService.selectAllUserCount(userInfo);
		recordsFiltered = recordsTotal;
		return "userJson";
	}

	
	public String userInsert(){
		String[] r = userService.insertUser(userInfo);
		resNum = r[0];
		res = r[1];
		return "userJson";
	}
	public String userUpdate(){
		String[] r = userService.updateUserById(userInfo);
		resNum = r[0];
		res = r[1];		
		return "userJson";
	}
	public String userDelete(){
		String[] r = userService.deleteUserById(userId);
		resNum = r[0];
		res = r[1];		
		return "userJson";
	}

	public String roleSelectList(){
		roleSelect = userService.roleSelectList();
		return "roleJson";
	}
	
	public String modifPw(){
		String[] r = userService.modifPw( oldPw, newPw1, newPw2,userId);
		resNum = r[0];
		res = r[1];	
		return "userJson";
	}
	



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<ResultMap> getUserList() {
		return userList;
	}
	public void setUserList(List<ResultMap> userList) {
		this.userList = userList;
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

	public List<ResultMap> getRoleSelect() {
		return roleSelect;
	}

	public void setRoleSelect(List<ResultMap> roleSelect) {
		this.roleSelect = roleSelect;
	}

	public String getOldPw() {
		return oldPw;
	}

	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}

	public String getNewPw1() {
		return newPw1;
	}

	public void setNewPw1(String newPw1) {
		this.newPw1 = newPw1;
	}

	public String getNewPw2() {
		return newPw2;
	}

	public void setNewPw2(String newPw2) {
		this.newPw2 = newPw2;
	}
	
	


	
}
