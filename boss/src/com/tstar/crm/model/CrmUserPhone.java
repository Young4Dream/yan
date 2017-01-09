package com.tstar.crm.model;

import java.util.Date;

public class CrmUserPhone {
    private String id;

    private String phoneNo;

    private String phoneAlias;

    private String deviceCode;

    private String pwd;

    private String phoneLevel;

    private Date convertTime;

    private String callPolicy;

    private String adjustPolicy;

    private String secretLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getPhoneAlias() {
        return phoneAlias;
    }

    public void setPhoneAlias(String phoneAlias) {
        this.phoneAlias = phoneAlias == null ? null : phoneAlias.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPhoneLevel() {
        return phoneLevel;
    }

    public void setPhoneLevel(String phoneLevel) {
        this.phoneLevel = phoneLevel == null ? null : phoneLevel.trim();
    }

    public Date getConvertTime() {
        return convertTime;
    }

    public void setConvertTime(Date convertTime) {
        this.convertTime = convertTime;
    }

    public String getCallPolicy() {
        return callPolicy;
    }

    public void setCallPolicy(String callPolicy) {
        this.callPolicy = callPolicy == null ? null : callPolicy.trim();
    }

    public String getAdjustPolicy() {
        return adjustPolicy;
    }

    public void setAdjustPolicy(String adjustPolicy) {
        this.adjustPolicy = adjustPolicy == null ? null : adjustPolicy.trim();
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel == null ? null : secretLevel.trim();
    }
    
    ///////////////////////////////////////
    private String phoneLevelDesc;
    private String callPolicyDesc;
    private String adjustPolicyDesc;
    private String secretLevelDesc;

	public String getPhoneLevelDesc() {
		return phoneLevelDesc;
	}

	public void setPhoneLevelDesc(String phoneLevelDesc) {
		this.phoneLevelDesc = phoneLevelDesc;
	}

	public String getCallPolicyDesc() {
		return callPolicyDesc;
	}

	public void setCallPolicyDesc(String callPolicyDesc) {
		this.callPolicyDesc = callPolicyDesc;
	}

	public String getAdjustPolicyDesc() {
		return adjustPolicyDesc;
	}

	public void setAdjustPolicyDesc(String adjustPolicyDesc) {
		this.adjustPolicyDesc = adjustPolicyDesc;
	}

	public String getSecretLevelDesc() {
		return secretLevelDesc;
	}

	public void setSecretLevelDesc(String secretLevelDesc) {
		this.secretLevelDesc = secretLevelDesc;
	}
}