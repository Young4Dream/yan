package com.tstar.crm.model;

import java.util.Date;

public class CrmUser {
    private String id;

    private String customerId;

    private String businessType;

    private String businessKey;

    private String name;

    private String departmentId;

    private String address;

    private String linkPhone;

    private Integer status;

    private Integer payPolicy;

    private String relTable;

    private String creator;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    private Date effectiveTime;
    
    private Date expiryTime;
    
    private Integer billingDay;
    
    private String businessArea;
    
    private String userArea;
    
    private String postAddress;

    public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public Integer getBillingDay() {
		return billingDay;
	}

	public void setBillingDay(Integer billingDay) {
		this.billingDay = billingDay;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayPolicy() {
        return payPolicy;
    }

    public void setPayPolicy(Integer payPolicy) {
        this.payPolicy = payPolicy;
    }

    public String getRelTable() {
        return relTable;
    }

    public void setRelTable(String relTable) {
        this.relTable = relTable == null ? null : relTable.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
    
    /////////////////////////////////////
    private String fullText;
    private String payPolicyDesc;
    private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public String getPayPolicyDesc() {
		return payPolicyDesc;
	}

	public void setPayPolicyDesc(String payPolicyDesc) {
		this.payPolicyDesc = payPolicyDesc;
	}
	
	private Integer beginStatus;
	
	private Integer endStatus;

	public Integer getBeginStatus() {
		return beginStatus;
	}

	public void setBeginStatus(Integer beginStatus) {
		this.beginStatus = beginStatus;
	}

	public Integer getEndStatus() {
		return endStatus;
	}

	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}
	
	private String businessTypeDesc;

	public String getBusinessTypeDesc() {
		return businessTypeDesc;
	}

	public void setBusinessTypeDesc(String businessTypeDesc) {
		this.businessTypeDesc = businessTypeDesc;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
}