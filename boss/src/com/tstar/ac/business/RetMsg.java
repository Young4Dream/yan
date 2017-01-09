/**
 * 北向接口返回消息
 */
package com.tstar.ac.business;

/**
 * @author zhumengfeng
 *
 */
public class RetMsg {
	private String retCode;
	private String retDesc;
	
	public RetMsg() {}
	
	public RetMsg(String retCode, String retDesc) {
		this.retCode = retCode;
		this.retDesc = retDesc;
	}
	
	public String getRetCode() { return this.retCode; }
	public void setRetCode(String retCode) { this.retCode = retCode; }
	
	public String getRetDesc() { return this.retDesc; }
	public void setRetDesc(String retDesc) { this.retDesc = retDesc; }
}
