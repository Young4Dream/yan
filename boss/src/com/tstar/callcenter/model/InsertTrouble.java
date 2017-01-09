package com.tstar.callcenter.model;

/**
 * 插入故障
 * 
 * @author lixm
 * 
 */
public class InsertTrouble {

	private String jobtype;// 故障类型,固定值
	private String thiskey;// 故障号码
	private String gzxx;// -故障现象
	private String linkphone;// -联系电话
	private String linkman;// -联系人
	private String sslbm;// 受理部门编号
	private String jlry;// --接入人员
	private String ywarea;// 业务区域
	private String username;// 用户名称
	private String address;// 用户地址
	private String usertype;// 用户类型
	private String callerid;// 主叫号码
	private String bz;// 备注
	private String userid;// 操作员工号
	private String datatype;

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getThiskey() {
		return thiskey;
	}

	public void setThiskey(String thiskey) {
		this.thiskey = thiskey;
	}

	public String getGzxx() {
		return gzxx;
	}

	public void setGzxx(String gzxx) {
		this.gzxx = gzxx;
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}


	public String getSslbm() {
		return sslbm;
	}

	public void setSslbm(String sslbm) {
		this.sslbm = sslbm;
	}

	public String getJlry() {
		return jlry;
	}

	public void setJlry(String jlry) {
		this.jlry = jlry;
	}

	public String getYwarea() {
		return ywarea;
	}

	public void setYwarea(String ywarea) {
		this.ywarea = ywarea;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getCallerid() {
		return callerid;
	}

	public void setCallerid(String callerid) {
		this.callerid = callerid;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

}
