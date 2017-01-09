package com.tstar.callcenter.model.autogenerate;

import java.util.Date;

public class UserInfo {
    private long userId;

    private String userName;

    private String password;

    private long roleId;

    private Date createTime;

    private Date updateTime;

    private String remark;
    //boss工号
    private String s1;
    

    private String s2;

    private String s3;

    private String s4;

    private String s5;

    private long num1;

    private long num2;

    private long num3;
    

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

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4 == null ? null : s4.trim();
    }

    public String getS5() {
        return s5;
    }

    public void setS5(String s5) {
        this.s5 = s5 == null ? null : s5.trim();
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
}