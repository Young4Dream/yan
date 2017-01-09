package com.tstar.callcenter.model.autogenerate;

import java.util.Date;

public class UserEmplInfo {
    private long userId;

    private String userName;

    private String password;

    private long roleId;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private String s1;

    private String s2;

    private String s3;

    private long num1;

    private long num2;

    private long num3;

    private long isAdmin;

    private String type;
    
    private String bossPwd;

    private long deptId;

   

	private String name;

    private String gender;

    private long age;

    private Date birthday;

    private Date joinDate;

    private String tel;

    private String mobile;

    private String email;

    private String certificateId;

    private long isAgent;

    private String monitorDept;

    private String deptName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1 == null ? null : s1.trim();
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2 == null ? null : s2.trim();
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3 == null ? null : s3.trim();
    }

    public long getNum1() {
        return num1;
    }

    public void setNum1(long num1) {
        this.num1 = num1;
    }

    public long getNum2() {
        return num2;
    }

    public void setNum2(long num2) {
        this.num2 = num2;
    }

    public long getNum3() {
        return num3;
    }

    public void setNum3(long num3) {
        this.num3 = num3;
    }

    public long getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(long isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    public String getBossPwd() {
		return bossPwd;
	}

	public void setBossPwd(String bossPwd) {
		this.bossPwd = bossPwd;
	}
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId == null ? null : certificateId.trim();
    }

    public long getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(long isAgent) {
        this.isAgent = isAgent;
    }

    public String getMonitorDept() {
        return monitorDept;
    }

    public void setMonitorDept(String monitorDept) {
        this.monitorDept = monitorDept == null ? null : monitorDept.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}