package com.tstar.callcenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.admin.AdminConfMapper;
import com.tstar.callcenter.dao.autogenerate.TroubleAcceptMapper;
import com.tstar.callcenter.dao.autogenerate.UserEmplInfoMapper;
import com.tstar.callcenter.interceptor.SessionUserListener;
import com.tstar.callcenter.model.UserSession;
import com.tstar.callcenter.model.autogenerate.UserEmplInfo;
import com.tstar.callcenter.model.autogenerate.UserEmplInfoExample;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.pub.tools.EncryptUtil;
import com.tstar.callcenter.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	// key为sessionId，value为HttpSession，使用static，定义静态变量，使之程序运行时，一直存在内存中。  
   // private static Map<Long, String> sessionMap = new HashMap<Long, String>(500); 
    
	private static HttpSession session;
	//private  Map<String, Object> session;
	
	@Resource
	private UserEmplInfoMapper userEmplInfoMapper;
	@Resource
	private TroubleAcceptMapper troubleAcceptMapper;
	@Resource
	private AdminConfMapper adminConfMapper;
	

	/**
	 * 登录
	 * 
	 * @return res  
	 * 			-1-失败，用户不存在
	 * 			 0-失败，密码不正确
	 * 			 1-成功，登录成功
	 */
	public String[] login(String userName,String password,String phone,String ip, String gwIp, long admin){
		String[] res = {"",""};
		
		/*
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		*/
		UserEmplInfoExample example = new UserEmplInfoExample();
		UserEmplInfoExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andIsAdminEqualTo(admin);
        List<UserEmplInfo> list = userEmplInfoMapper.selectByExample(example);
        
		password = EncryptUtil.encrypt(password);
		if(list==null||list.size()==0){
			res[0] = "-1";
			res[1] = "用户不存在!";
		}else{
			Boolean hasLogin = SessionUserListener.checkIfHasLogin(list.get(0));
			//if(isLoginOrNot(list.get(0))){//验证是否已登录true 已登录
			if(hasLogin){//验证是否已登录true 已登录
				res[0] = "0";
				res[1] = "用户已登录，请勿重复登录!";
			}else{
				if(password.equals(list.get(0).getPassword())){
					res[0] = "1";
					res[1] = "登录成功!";
					
					//插入登录日志
					if(!userName.endsWith("admin")){
						
					ResultMap map = new ResultMap();
					
					map.put("login_time", new Date());
					map.put("phone", phone);
					map.put("empl_no", userName);
					
					List<ResultMap> ss = adminConfMapper.selectEmplNameByEmplNo(map);
					String emplName = ss.get(0).getAttribute("name");
					map.put("empl_name", emplName);
					
					adminConfMapper.insertLoginLog(map);
					}
					
					setSession(list.get(0),phone,ip,gwIp);
					
				}else{
					res[0] = "0";
					res[1] = "密码不正确!";
				}
			}
			
		}
		
		//logger.info("User----"+userName+":------loginResult:"+res[1]);
		
		return res;
	}
	
	public void logout() {
		// TODO Auto-generated method stub
//		session = ActionContext.getContext().getSession();
//		session.remove("userInfo");
		session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("userInfo");
		
		SessionUserListener.removeSession(session.getId());
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void setSession(UserEmplInfo user,String phone,String ip, String gwIp){		
		UserSession userSession = new UserSession();
		userSession.setIp(ip);
		userSession.setGwIp(gwIp);
		userSession.setPhone(phone);
		userSession.setRoleId(user.getRoleId()+"");
		userSession.setUserId(user.getUserId()+"");
		userSession.setUserName(user.getUserName());
		userSession.setName(user.getName());
		userSession.setDeptName(user.getDeptName());
		userSession.setIsAdmin(user.getIsAdmin());
		
		if(!user.getUserName().equals("admin")){
			
			//List<ResultMap> loginUserList = new ArrayList<ResultMap>();
			ResultMap params = new ResultMap();
			params.put("v_userid", user.getS1());
			try {
				params.put("v_password", EncryptUtil.decrypt(user.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.put("v_loginip", ip);
			params.put("cv_1", new ArrayList<ResultMap>());
			troubleAcceptMapper.selectLoginUser(params);
			
			List<ResultMap> loginUserList = (List<ResultMap>) params.get("cv_1");
			ResultMap loginUser = loginUserList.get(0);
			loginUser.get("userarea");//管理区域
			loginUser.get("bmid");//部门编号
		
			userSession.setBmid(loginUser.get("bmid")+"");
			userSession.setUserarea(loginUser.get("userarea")+"");
			userSession.setBossuser(user.getType());//boss 工号
			userSession.setBossPwd(user.getBossPwd());
		}
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userInfo", userSession);
		
		if (SessionUserListener.containsKey(session.getId())) {
            SessionUserListener.removeSession(session.getId());  
        }  
        //把当前用户封装的session按，sessionID和session进行键值封装，添加到静态变量map中。  
        SessionUserListener.addUserSession(session);
        
        //放进map
//        Map<String,String[]> setmap = new HashMap<String,String[]>();
//        String[] value = {user.getUserName(),user.getName()}; 
//        setmap.put(phone, value);
//        ParamUtil.setUSER_NO_TEL_MAP(setmap);
		
	}
	


	public String getLoginUserName() {
		
		return null;
	}

	public int isLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

}
