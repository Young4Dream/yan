/**
 * 
 */
package com.tstar.crm.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhumengfeng
 *
 */
public class AdslAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	public String goToCreatePage() {
		return "createUser";
	}

	public String goToDeletePage() {
		return "deleteUser";
	}
	
	public String goToEditPage() {
		return "editUser";
	}
	
	public String goToChangePage() {
		return "changeUser";
	}
	
	public String goToMovePage() {
		return "moveUser";
	}
	
	public String goToTransferPage() {
		return "transferUser";
	}
	
}