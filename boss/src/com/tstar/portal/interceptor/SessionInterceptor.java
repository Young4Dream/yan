package com.tstar.portal.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor{

	/**
	 * Session拦截器
	 * @author lixm
	 * 2015-5-5 15:02
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//取得请求的URL  
        String url = ServletActionContext.getRequest().getRequestURL().toString(); 
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setHeader("Pragma","No-cache");            
        response.setHeader("Cache-Control","no-cache");     
        response.setHeader("Cache-Control", "no-store");     
        response.setDateHeader("Expires",0);  
        //对登录与注销,登录页面获取ip地址请求直接放行,不予拦截
        if (url.indexOf("login") != -1 || url.indexOf("logout") != -1 || url.indexOf("selectSysIp") != -1) {
            return invocation.invoke();  
        }  
        else{  
            //验证Session是否过期  
            if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){  
                //session过期,转向session过期提示页,最终跳转至登录页面  
                return "loginPage";  
            }  
            else{  
            	Map<String, Object> session = ActionContext.getContext().getSession();
                //验证是否已经登录  
                if (session == null || session.size() == 0){ 
                    //尚未登录,跳转至登录页面  
                    return "loginPage";  
                }
                else{                      
                    return invocation.invoke();  
                }                  
            }              
        }  
    }  

}
