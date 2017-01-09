package com.tstar.callcenter.model;

public class UserSession {
	
	public String userId;
	private String userName;
	public String roleId;
	public String phone;
	public String ip;
	public String name;
	public String deptName;
	public String userarea;//管理区域 与boss
	public String bmid;//部门编号 与boss
	public String bossuser;//boss工号
	
	
	public String gwIp;//外呼网关IP
	
	public String bossPwd;
	
	public long isAdmin;
	
	public long getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(long isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getBossPwd() {
		return bossPwd;
	}
	public void setBossPwd(String bossPwd) {
		this.bossPwd = bossPwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public String getUserarea() {
		return userarea;
	}
	public void setUserarea(String userarea) {
		this.userarea = userarea;
	}
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getBossuser() {
		return bossuser;
	}
	public void setBossuser(String bossuser) {
		this.bossuser = bossuser;
	}
    public String getGwIp() {
        return gwIp;
    }
    public void setGwIp(String gwIp) {
        this.gwIp = gwIp;
    }

	
	
	

}
