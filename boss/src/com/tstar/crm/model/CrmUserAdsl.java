package com.tstar.crm.model;

public class CrmUserAdsl {
    private String id;

    private String acc;

    private String pwd;

    private String phoneNo;

    private String speed;

    private String ipAddress;

    private String macAddress;

    private String notifyPolicy;

    private String serviceOper;
    
    private String innerVlan;
    
    private String outerVlan;

    public String getInnerVlan() {
		return innerVlan;
	}

	public void setInnerVlan(String innerVlan) {
		this.innerVlan = innerVlan;
	}

	public String getOuterVlan() {
		return outerVlan;
	}

	public void setOuterVlan(String outerVlan) {
		this.outerVlan = outerVlan;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed == null ? null : speed.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress == null ? null : macAddress.trim();
    }

    public String getNotifyPolicy() {
        return notifyPolicy;
    }

    public void setNotifyPolicy(String notifyPolicy) {
        this.notifyPolicy = notifyPolicy == null ? null : notifyPolicy.trim();
    }

    public String getServiceOper() {
        return serviceOper;
    }

    public void setServiceOper(String serviceOper) {
        this.serviceOper = serviceOper == null ? null : serviceOper.trim();
    }
    
    ///////////////////////////////////////////////////////
    private String speedDesc;
    private String serviceOperDesc;
    private String notifyPolicyDesc;

	public String getServiceOperDesc() {
		return serviceOperDesc;
	}

	public void setServiceOperDesc(String serviceOperDesc) {
		this.serviceOperDesc = serviceOperDesc;
	}

	public String getSpeedDesc() {
		return speedDesc;
	}

	public void setSpeedDesc(String speedDesc) {
		this.speedDesc = speedDesc;
	}

	public String getNotifyPolicyDesc() {
		return notifyPolicyDesc;
	}

	public void setNotifyPolicyDesc(String notifyPolicyDesc) {
		this.notifyPolicyDesc = notifyPolicyDesc;
	}
    
}