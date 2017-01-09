package com.tstar.portal.model;

public class UserSession {
	
	public String id;
	private String userName;
	public String roleId;
	public String userAlias;
	public String deptId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
    public String getDeptId() {
        return deptId;
    }
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public String getUserAlias() {
        return userAlias;
    }
    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

}
