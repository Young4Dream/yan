package com.tstar.callcenter.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.SystemConfMapper;
import com.tstar.callcenter.dao.autogenerate.UserInfoMapper;
import com.tstar.callcenter.model.autogenerate.UserInfo;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.pub.tools.EncryptUtil;
import com.tstar.callcenter.service.UserService;



@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserInfoMapper userMapper;
	@Resource
	SystemConfMapper systemConfMapper;


	public List<ResultMap> selectUserByPage(UserInfo userInfo, int start,
			int length) {
		ResultMap paraMap = new ResultMap();
		if(userInfo!=null){
			paraMap.put("user_name", userInfo.getUserName());
			paraMap.put("role_id", userInfo.getRoleId());
			paraMap.put("user_id", userInfo.getUserId());
		}
//		paraMap.put("pageSize", length);
//		paraMap.put("offset", start);
		PageHelper.startPage(start/length+1, length);
		return systemConfMapper.selectUserByPage(paraMap);
	}
	
	public int selectAllUserCount(UserInfo userInfo) {
		// TODO Auto-generated method stub
		ResultMap paraMap = new ResultMap();
		if(userInfo!=null){
			paraMap.put("user_name", userInfo.getUserName());
			paraMap.put("role_id", userInfo.getRoleId());
			paraMap.put("user_id", userInfo.getUserId());
		}
		return systemConfMapper.selectUserByCount(paraMap);
	}

	public String[] insertUser(UserInfo record) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		
		record.setCreateTime(new Date());
		record.setPassword(EncryptUtil.encrypt(record.getPassword()));
		logger.info("UserServiceImpl------insert------"+record.getUserName());
		int result = userMapper.insertSelective(record);
		
		if(result>0){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}

	public String[] updateUserById(UserInfo record) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		if(record.getPassword()!=null){
			if(!"".equals(record.getPassword())){
				record.setPassword(EncryptUtil.encrypt(record.getPassword()));
			}
		}
		record.setUpdateTime(new Date());
		int result = userMapper.updateByPrimaryKeySelective(record);
		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String[] deleteUserById(long id) {
		// TODO Auto-generated method stub
		int result = 0;
		String[] res = {"",""};
		result = userMapper.deleteByPrimaryKey(id);
		if(result>0){
			res[1]="删除成功!";
			res[0]="1";
		}else{
			res[1]="删除失败!";
			res[0]="0";			
		}
		return res;
	}

	public List<ResultMap> roleSelectList() {
		// TODO Auto-generated method stub
		return systemConfMapper.roleSelectList();
	}

	public String[] modifPw(String oldPw, String newPw1, String newPw2,long userId) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		oldPw = EncryptUtil.encrypt(oldPw);
		UserInfo user = userMapper.selectByPrimaryKey(userId);
		if(!user.getPassword().equals(oldPw)){
			res[1]="原密码不正确！";
			res[0]="0";	
		}else{
			newPw1 = EncryptUtil.encrypt(newPw1);
			user.setUpdateTime(new Date());
			user.setPassword(newPw1);
			int result = userMapper.updateByPrimaryKeySelective(user);
			if(result>0){
				res[1]="更改成功!";
				res[0]="1";
			}else{
				res[1]="更改失败!";
				res[0]="0";			
			}
		}
		
		return res;
	}






}
