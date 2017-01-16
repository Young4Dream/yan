package com.tstar.res.model;

import java.util.Date;

public class ResPhoneNumber {
    private String id;

    private String phoneNumber;

    private String rootDeviceCode;

    private Integer numberLevel;

    private Integer reserved;

    private Integer status;

    private Date unlockTime;

    private String customerName;

    private String remark;
    private RefBusinessArea refBusinessArea;
    private ResBillingArea resBillingArea;

    public RefBusinessArea getRefBusinessArea() {
		return refBusinessArea;
	}

	public void setRefBusinessArea(RefBusinessArea refBusinessArea) {
		this.refBusinessArea = refBusinessArea;
	}

	public ResBillingArea getResBillingArea() {
		return resBillingArea;
	}

	public void setResBillingArea(ResBillingArea resBillingArea) {
		this.resBillingArea = resBillingArea;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getRootDeviceCode() {
        return rootDeviceCode;
    }

    public void setRootDeviceCode(String rootDeviceCode) {
        this.rootDeviceCode = rootDeviceCode == null ? null : rootDeviceCode.trim();
    }

    public Integer getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(Integer numberLevel) {
        this.numberLevel = numberLevel;
    }

    public Integer getReserved() {
        return reserved;
    }

    public void setReserved(Integer reserved) {
        this.reserved = reserved;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(Date unlockTime) {
        this.unlockTime = unlockTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    public String getNumberLevelDesc() {
    	if (numberLevel == null) {
    		return "";
    	} else if (numberLevel == 0) {
    		return "普通";
    	} else if (numberLevel == 1) {
    		return "VIP";
    	} else {
    		return "";
    	}
    }
    
    public String getReservedDesc() {
    	if (reserved == null) {
    		return "";
    	} else if (reserved == 0) {
    		return "不保留";
    	} else if (reserved == 1) {
    		return "保留";
    	} else {
    		return "";
    	}
    }
    
    public String getStatusDesc() {
    	if (status == null) {
    		return "";
    	} else if (status == 0) {
    		return "空闲";
    	} else if (status == 1) {
    		return "临时锁定";
    	} else if (status == 2) {
    		return "锁定";
    	} else if (status == 9) {
    		return "占用";
    	} else {
    		return "";
    	}
    }
    
    private String endPhoneNumber;

	public String getEndPhoneNumber() {
		return endPhoneNumber;
	}

	public void setEndPhoneNumber(String endPhoneNumber) {
		this.endPhoneNumber = endPhoneNumber;
	}
	
}