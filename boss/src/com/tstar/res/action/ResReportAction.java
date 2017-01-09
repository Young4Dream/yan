/**
 * 
 */
package com.tstar.res.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhumengfeng
 *
 */
public class ResReportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String goToPage() {
		HttpServletRequest request= ServletActionContext.getRequest();
		String key = request.getParameter("reportKey");
		ActionContext.getContext().getSession().put("reportKey", key);
		/*
		Enumeration<String> parmNames = request.getParameterNames();
		if (parmNames != null) {
			for(Enumeration e = parmNames; e.hasMoreElements();){
				String parmName = e.nextElement().toString();
			    String parmValue = request.getParameter(parmName);
			    System.out.println(parmName + "--------------" + parmValue);
			    ActionContext.getContext().getSession().put(parmName, parmValue);
			}
		}
		*/
		return "showHomePage";
	}
		
}
