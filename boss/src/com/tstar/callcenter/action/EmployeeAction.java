package com.tstar.callcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.tstar.callcenter.model.autogenerate.DeptInfo;
import com.tstar.callcenter.model.autogenerate.EmployeeInfo;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.EmployeeService;


public class EmployeeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String res;
	private String resNum;
	private String userId;
	private long employeeId;
	private long deptId;
	private int recordsTotal;
	private int draw;
	private int recordsFiltered;
	private int start;
	private int length;
	private EmployeeInfo employeeInfo=new EmployeeInfo();
	private List<ResultMap> emplList = new ArrayList<ResultMap>();
	private List<ResultMap> deptList = new ArrayList<ResultMap>();
	private List<ResultMap> deptSelect = new ArrayList<ResultMap>();
	private JSONArray skillTree = new JSONArray();
	private DeptInfo deptInfo = new DeptInfo();
	
	//private String test;
	
	
	@Resource
	private EmployeeService employeeService;
	
	public String goToEmplPage(){
		return "emplPage";
	}
	
	public String selectEmplList(){
		emplList = employeeService.selectEmplList(employeeInfo, start, length);
		recordsTotal = employeeService.selectAllEmplCount(employeeInfo);
		recordsFiltered = recordsTotal;
		return "emplList";
	}
	
	public String skillTree(){
		skillTree = employeeService.skillJson(employeeId);
		return "skillTree";
		
	}
	
	public String insertEmpl(){
		String[] r = employeeService.insertEmplInfo(employeeInfo);
		resNum = r[0];
		res = r[1];
		return "emplList";
	}
	
	public String updataEmpl(){
		String[] r = employeeService.updateEmplById(employeeInfo);
		resNum = r[0];
		res = r[1];
		return "emplList";
	}
	
	public String deleteEmpl(){
		String[] r = employeeService.deleteEmplById(employeeId,userId);
		resNum = r[0];
		res = r[1];
		return "emplList";
	}
	
	public String deptSelectList(){
		deptSelect = employeeService.deptSelectList();	
		return "emplList";
	}

	
	
	
	
	public String selectDeptList(){
		deptList = employeeService.selectDeptListByPage(deptInfo, start, length);
		recordsTotal = employeeService.selectAllDeptCount(deptInfo);
		recordsFiltered = recordsTotal;
		return "emplList";
	}
	
	
	public String insertDept(){
		String[] r = employeeService.insertDept(deptInfo);
		resNum = r[0];
		res = r[1];
		return "emplList";
	}
	
	public String updataDept(){
		String[] r = employeeService.updateDeptById(deptInfo);
		resNum = r[0];
		res = r[1];
		return "emplList";
	}
	
	public String deleteDept(){
		String[] r = employeeService.deleteDeptById(deptId);
		resNum = r[0];
		res = r[1];
		return "emplList";
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

//	public int getStart() {
//		return start;
//	}

	public void setStart(int start) {
		this.start = start;
	}

//	public int getLength() {
//		return length;
//	}

	public void setLength(int length) {
		this.length = length;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

//	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
//		this.employeeInfo = employeeInfo;
//	}

	public List<ResultMap> getEmplList() {
		return emplList;
	}

	public void setEmplList(List<ResultMap> emplList) {
		this.emplList = emplList;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public JSONArray getSkillTree() {
		return skillTree;
	}

	public void setSkillTree(JSONArray skillTree) {
		this.skillTree = skillTree;
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

//	public long getDeptId() {
//		return deptId;
//	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

//	public void setDeptInfo(DeptInfo deptInfo) {
//		this.deptInfo = deptInfo;
//	}

	public List<ResultMap> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<ResultMap> deptList) {
		this.deptList = deptList;
	}

	public List<ResultMap> getDeptSelect() {
		return deptSelect;
	}

	public void setDeptSelect(List<ResultMap> deptSelect) {
		this.deptSelect = deptSelect;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
