package com.tstar.callcenter.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.dao.autogenerate.DeptInfoMapper;
import com.tstar.callcenter.dao.autogenerate.EmployeeInfoMapper;
import com.tstar.callcenter.dao.autogenerate.UserInfoMapper;
import com.tstar.callcenter.model.autogenerate.DeptInfo;
import com.tstar.callcenter.model.autogenerate.DeptInfoExample;
import com.tstar.callcenter.model.autogenerate.EmployeeInfo;
import com.tstar.callcenter.model.autogenerate.UserInfo;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.pub.tools.EncryptUtil;
import com.tstar.callcenter.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Resource
	private EmployeeInfoMapper emplMapper;
	@Resource
	private AdminConfMapper adminConfMapper;
	@Resource
	private DeptInfoMapper deptInfoMapper;
	@Resource
	private UserInfoMapper userMapper;
	
	
	//@Transactional(rollbackFor=Exception.class) 事物回滚，可用于多个insert，update，delete操作的时候
	public List<ResultMap> selectEmplList(EmployeeInfo employeeInfo,int start,int length){
		ResultMap paraMap = new ResultMap();
		if(employeeInfo!=null){
			paraMap.put("employee_no", employeeInfo.getEmployeeNo());
			paraMap.put("name", employeeInfo.getName());
			paraMap.put("type", employeeInfo.getType());
			paraMap.put("dept_id", employeeInfo.getDeptId());
		}
//		paraMap.put("pageSize", length);
//		paraMap.put("offset", start);
		PageHelper.startPage(start/length+1, length);
		return adminConfMapper.selectEmplByPage(paraMap);
	}
	
	public int selectAllEmplCount(EmployeeInfo employeeInfo){
		ResultMap paraMap = new ResultMap();
		if(employeeInfo!=null){
			paraMap.put("employee_no", employeeInfo.getEmployeeNo());
			paraMap.put("name", employeeInfo.getName());
			paraMap.put("type", employeeInfo.getType());
			paraMap.put("dept_id", employeeInfo.getDeptId());
		}
		return adminConfMapper.selectEmplByCount(paraMap);
	}
	
	@Transactional(rollbackFor=Exception.class) //事物回滚，可用于多个insert，update，delete操作的时候
	public String[] insertEmplInfo(EmployeeInfo employeeInfo){
		
		String[] res = {"",""};
		int result = 0;
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(employeeInfo.getEmployeeNo());
		userInfo.setS1(employeeInfo.getType());//boss gonghao 
		userInfo.setCreateTime(new Date());
		userInfo.setPassword(EncryptUtil.encrypt(employeeInfo.getPassword()));
		logger.info("UserServiceImpl------insert------"+userInfo.getUserName());
		int ures = userMapper.insert(userInfo);
		if(ures>0){
			employeeInfo.setMemo1(userInfo.getUserId()+"");//Memo1 为 userId
			result = emplMapper.insertSelective(employeeInfo);
		}

		if(result>0){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}
	
	@Transactional(rollbackFor=Exception.class) //事物回滚，可用于多个insert，update，delete操作的时候
	public String[] updateEmplById(EmployeeInfo employeeInfo){
		String[] res = {"",""};
		int result = 0;
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(Long.parseLong(employeeInfo.getMemo1()));//Memo1 为 userId
		userInfo.setUserName(employeeInfo.getEmployeeNo());
		userInfo.setS1(employeeInfo.getType());//boss gonghao
		userInfo.setUpdateTime(new Date());
		if(!"".equals(employeeInfo.getPassword())){
			userInfo.setPassword(EncryptUtil.encrypt(employeeInfo.getPassword()));
		}else{
			userInfo.setPassword("");
		}
		logger.info("UserServiceImpl------update------"+userInfo.getUserName());
		int ures = userMapper.updateByPrimaryKeySelective(userInfo);
		if(ures>0){
			
			result = emplMapper.updateByPrimaryKeySelective(employeeInfo);
		}

		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;		
	}
	
	@Transactional(rollbackFor=Exception.class) //事物回滚，可用于多个insert，update，delete操作的时候
	public String[] deleteEmplById(long emplid,String userId){
		String[] res = {"",""};
		int result = 0;
		int ures = userMapper.deleteByPrimaryKey(Long.parseLong(userId));
		if(ures>0){
			result = emplMapper.deleteByPrimaryKey(emplid);
		}
		if(result>0){
			res[1]="删除成功!";
			res[0]="1";
		}else{
			res[1]="删除失败!";
			res[0]="0";			
		}
		return res;	
	}
	
	
	
	private List<Long> selectSkillIds(long emplId){
		return adminConfMapper.selectSkillIdByEmplId(emplId);
	}
	
	//skill树
	public JSONArray skillJson(long emplId){
		List<Long> skills = selectSkillIds(emplId);
		List<ResultMap> skillList = adminConfMapper.selectSkillTreeChild();
		List<ResultMap> groupList = adminConfMapper.selectSkillGroups();
		JSONArray array = new JSONArray();
		
		//生成父节点
		for(int i=0;i<groupList.size();i++){
			String str = "{'id':'"+groupList.get(i).getAttribute("group_id")+"','pId':'"+groupList.get(i).getAttribute("parent_id")+"','name':'"+groupList.get(i).getAttribute("group_name")+"','open':'true','nocheck':true";
				str=str + "}";
			JSONObject object = JSON.parseObject(str); 
			array.add(object);
		}
		
		//生成子节点
		for(int j=0;j<skillList.size();j++){
			String str = "{'id':'"+skillList.get(j).getAttribute("skill_id")+"','pId':'"+skillList.get(j).getAttribute("group_id")
						+"','name':'"+skillList.get(j).getAttribute("skill_code")+"-"+skillList.get(j).getAttribute("skill_name")
						+"','open':'true'";
		
			long skillId = skillList.get(j).getLong("skill_id");
			for(int i=0;i<skills.size();i++){
				if(skillId ==skills.get(i)){
					str=str + ",'checked':'true'";
					skills.remove(i);
					break;
				}
			}
				str=str + "}";

			JSONObject object = JSON.parseObject(str); 
			array.add(object);
		}
		
		return array;
	}
	
	
	
	public String [] insertDept(DeptInfo deptInfo){
		String[] res = {"",""};
		int result = deptInfoMapper.insertSelective(deptInfo);
		if(result>0){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String [] updateDeptById(DeptInfo deptInfo){
		String[] res = {"",""};
		int result = deptInfoMapper.updateByPrimaryKeySelective(deptInfo);
		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String [] deleteDeptById(long deptId){
		String[] res = {"",""};
		ResultMap param = new ResultMap();
		param.put("dept_id", deptId);
		int deptChild = adminConfMapper.selectDeptChildByCount(param);
		int emplCount = adminConfMapper.selectEmplCountByDept(param);
		if(deptChild>0){
			res[1]="删除失败!此条记录下存在部门，暂不能删除！";
			res[0]="0";	
		}else if(emplCount>0){
			res[1]="删除失败!此条记录下存在员工，暂不能删除！";
			res[0]="0";	
		}else{
			int result = deptInfoMapper.deleteByPrimaryKey(deptId);
			if(result>0){
				res[1]="删除成功!";
				res[0]="1";
			}else{
				res[1]="删除失败!";
				res[0]="0";			
			}
		}

		return res;
	}

	
	public List<ResultMap> selectDeptListByPage(DeptInfo deptInfo,int start,int length){
		ResultMap paraMap = new ResultMap();
		if(deptInfo!=null){
			paraMap.put("dept_name", deptInfo.getDeptName());
			paraMap.put("parent_id", deptInfo.getParentId());	
		}
//		paraMap.put("pageSize", length);
//		paraMap.put("offset", start);
		List<DeptInfo> deptAllList = deptInfoMapper.selectByExample(new DeptInfoExample());
		PageHelper.startPage(start/length+1, length);
		List<ResultMap> deptList = adminConfMapper.selectDeptByPage(paraMap);
		for(ResultMap dept : deptList){
		if(dept.getAttribute("parent_id").equals("0")){
			dept.setAttribute("parent_name", " ");
		}else{
			for(int i=0;i<deptAllList.size();i++){
				if(dept.getLong("parent_id")==deptAllList.get(i).getDeptId()){
					dept.setAttribute("parent_name", deptAllList.get(i).getDeptName());
				}
			}				
		}	
	}	
		return deptList;
	}
	
	public int selectAllDeptCount(DeptInfo deptInfo){
		ResultMap paraMap = new ResultMap();
		if(deptInfo!=null){
			paraMap.put("dept_name", deptInfo.getDeptName());
			paraMap.put("parent_id", deptInfo.getParentId());	
		}
		return adminConfMapper.selectDeptByCount(paraMap);
		
	}
	
	public List<ResultMap> deptSelectList(){
		return adminConfMapper.deptSelectList();
	}


	
	
	
}
