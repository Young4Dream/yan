package com.tstar.callcenter.model;

import java.util.Date;

public class PhoneTrouble {
	public String phoneNum; //电话号码
	
	public String contact;  //联系电话
	
	public String troubleTpye; //故障类型必填（数字：1、2、3。。。）
	
	public String recordFile;  //录音文件选填（空）
	
	public String troubleInfo;  //故障信息选填（空）
	
	public Date date;  //申告日期
	
	public String remark;  //申告备注选填（空）
	
	public String recordDept;  //受理部门必填（六铺炕业务组、昌平科技园业务组、系统操作员、太阳宫业务受理组）
	
	public String emplNo;  //经理人员必填（操作员名称）
	
	public String contactUser;  //联系人选填，这里没具体规定是联系人，还是联系方式，数据库里存啥的都有
	
	public String recordArea;  //业务受理区域必填（六铺炕、东直门、昌平科技园、丰和园小区）
	
	public String area;  //area不知该字段何用

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTroubleTpye() {
		return troubleTpye;
	}

	public void setTroubleTpye(String troubleTpye) {
		this.troubleTpye = troubleTpye;
	}

	public String getRecordFile() {
		return recordFile;
	}

	public void setRecordFile(String recordFile) {
		this.recordFile = recordFile;
	}

	public String getTroubleInfo() {
		return troubleInfo;
	}

	public void setTroubleInfo(String troubleInfo) {
		this.troubleInfo = troubleInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRecordDept() {
		return recordDept;
	}

	public void setRecordDept(String recordDept) {
		this.recordDept = recordDept;
	}

	public String getEmplNo() {
		return emplNo;
	}

	public void setEmplNo(String emplNo) {
		this.emplNo = emplNo;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getRecordArea() {
		return recordArea;
	}

	public void setRecordArea(String recordArea) {
		this.recordArea = recordArea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	



}
