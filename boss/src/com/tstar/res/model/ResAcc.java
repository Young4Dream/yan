package com.tstar.res.model;

import java.util.Date;

public class ResAcc {
    private String id;

    private String acc;

    private Integer status;

    private Date unlockTime;

    private String customerName;

    private String remark;
    
    private String endAcc;
    
    private String prefix;
    
    private String suffix;
    
    private String startAcc;
    
    private String bearable;

    public String getBearable() {
		return bearable;
	}

	public void setBearable(String bearable) {
		this.bearable = bearable;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getStartAcc() {
		return startAcc;
	}

	public void setStartAcc(String startAcc) {
		this.startAcc = startAcc;
	}

	public String getEndAcc() {
		return endAcc;
	}

	public void setEndAcc(String endAcc) {
		this.endAcc = endAcc;
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
}