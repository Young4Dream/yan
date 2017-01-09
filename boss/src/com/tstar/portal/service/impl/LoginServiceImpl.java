package com.tstar.portal.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.tstar.portal.dao.UserMapper;
import com.tstar.portal.interceptor.SessionUserListener;
import com.tstar.portal.model.User;
import com.tstar.portal.model.UserSession;
import com.tstar.portal.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	private static HttpSession session;
	
	@Resource
	private UserMapper daoUser;
	
	/**
	 * 登录
	 * 
	 * @return res  
	 * 			-1-失败，用户不存在
	 * 			 0-失败，密码不正确
	 * 			 1-成功，登录成功
	 */
	public String[] login(String userName,String password){
		String[] res = {"",""};
		
        User user = daoUser.selectByUserName(userName);
		//password = EncryptUtil.encrypt(password);
		
		if(user == null) {
			res[0] = "-1";
			res[1] = "用户不存在!";
		} else {
			if (password.equals(user.getPassword())) {
				res[0] = "1";
				res[1] = "登录成功!";
				
				//插入登录日志
				// TODO:
				
				setSession(user);
				
			} else {
				res[0] = "0";
				res[1] = "密码不正确!";
			}
		}
		return res;
	}
	
	public void logout() {
		session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("userInfo");
		SessionUserListener.removeSession(session.getId());
	}
	
	@SuppressWarnings("unchecked")
	private void setSession(User user){		
		UserSession userSession = new UserSession();
		userSession.setRoleId(user.getRoleId());
		userSession.setId(user.getId());
		userSession.setUserName(user.getUserName());
		userSession.setUserAlias(user.getUserAlias());
		userSession.setDeptId(user.getDeptId());

		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userInfo", userSession);
		
		if (SessionUserListener.containsKey(session.getId())) {
            SessionUserListener.removeSession(session.getId());  
        }  
        //把当前用户封装的session按，sessionID和session进行键值封装，添加到静态变量map中。  
        SessionUserListener.addUserSession(session);
	}

}
