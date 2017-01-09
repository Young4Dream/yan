package com.tstar.ocs.model;

import java.math.BigDecimal;
import java.util.Date;

public class SidRate {
    private String id;

    private String serviceId;
    
    private String serviceName;

    private String name;

    private Integer rateType;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    private String accountItemId;
    
    private String attachItemId;

    public String getAccountItemId() {
		return accountItemId;
	}

	public void setAccountItemId(String accountItemId) {
		this.accountItemId = accountItemId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
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
    
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    
    public String getRateTypeDesc() {
    	if (rateType == null) {
    		return "";
    	} else if (rateType == 0) {
    		return "标准费率";
    	} else if (rateType == 1) {
    		return "固定费率";
    	} else if (rateType == 2) {
    		return "T+1费率";
    	} else {
    		return "阶梯费率";
    	}
    }
    
    private BigDecimal price;

    private Integer baseDuration;

    private BigDecimal baseFee;

    private Integer baseUsage;

    private Integer threshold;
    
    private String planId;

    private BigDecimal attachPrice;
    
    private Integer attachUnitCount;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public Integer getBaseUsage() {
        return baseUsage;
    }

    public void setBaseUsage(Integer baseUsage) {
        this.baseUsage = baseUsage;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
    
    public String getPlanId() { return planId; }
    public void setPlanId(String planId) { this.planId = planId; }
    
    public BigDecimal getAttachPrice() {
    	return attachPrice;
    }
    
    public void setAttachPrice(BigDecimal attachPrice) {
    	this.attachPrice = attachPrice;
    }
    
    public Integer getAttachUnitCount() {
    	return attachUnitCount;
    }
    
    public void setAttachUnitCount(Integer attachUnitCount) {
    	this.attachUnitCount = attachUnitCount;
    }
    
    private String accountItemName;
    private String attachItemName;

	public String getAttachItemName() {
		return attachItemName;
	}

	public void setAttachItemName(String attachItemName) {
		this.attachItemName = attachItemName;
	}

	public String getAccountItemName() {
		return accountItemName;
	}

	public void setAccountItemName(String accountItemName) {
		this.accountItemName = accountItemName;
	}

	public String getAttachItemId() {
		return attachItemId;
	}

	public void setAttachItemId(String attachItemId) {
		this.attachItemId = attachItemId;
	}
    
}