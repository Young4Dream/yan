package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.autogenerate.UserInfo;
import com.tstar.callcenter.pub.data.ResultMap;

public interface UserService {
	
	public List<ResultMap> selectUserByPage(UserInfo record,int start,int length);
	
	public int selectAllUserCount(UserInfo record);
	
	public String[] insertUser(UserInfo record);
	
	public String[] updateUserById(UserInfo record);
	
	public String[] deleteUserById(long id);
	
	public List<ResultMap>roleSelectList();
	
	public String[] modifPw(String oldPw,String newPw1,String newPw2,long userId);
	
}
