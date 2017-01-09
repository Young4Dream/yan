package com.tstar.callcenter.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tstar.callcenter.model.autogenerate.DeptInfo;
import com.tstar.callcenter.model.autogenerate.EmployeeInfo;
import com.tstar.callcenter.pub.data.ResultMap;

public interface EmployeeService {
	
	public List<ResultMap> selectEmplList(EmployeeInfo employeeInfo,int start,int length);
	
	public int selectAllEmplCount(EmployeeInfo employeeInfo);
	
	public String[] insertEmplInfo(EmployeeInfo employeeInfo);
	
	public String[] updateEmplById(EmployeeInfo employeeInfo);
	
	public String[] deleteEmplById(long emplid,String userId);
	
	public JSONArray skillJson(long emplId);
	
	public String [] insertDept(DeptInfo deptInfo);
	
	public String [] updateDeptById(DeptInfo deptInfo);
	
	public String [] deleteDeptById(long deptId);
	
	List<ResultMap> selectDeptListByPage(DeptInfo deptInfo,int start,int length);
	
	int selectAllDeptCount(DeptInfo deptInfo);
	
	public List<ResultMap> deptSelectList();
	
	//public String selectT112();

}
