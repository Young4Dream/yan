package com.tstar.ocs.model;

import java.math.BigDecimal;
import java.util.Date;

public class SidPricePlan {
    private String id;

    private String name;

    private Integer planType;

    private String term;

    private BigDecimal planFee;

    private Integer durationLimit;

    private Integer durationFree;

    private Integer trafficLimit;

    private Integer trafficFree;

    private Integer occuranceLimit;

    private Integer occuranceFree;

    private String planDesc;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String remark;
    
    private String bearable;
    
    private String accountItemId;
    
    private String accountItemName;

    public String getAccountItemName() {
		return accountItemName;
	}

	public void setAccountItemName(String accountItemName) {
		this.accountItemName = accountItemName;
	}

	public String getAccountItemId() {
		return accountItemId;
	}

	public void setAccountItemId(String accountItemId) {
		this.accountItemId = accountItemId;
	}

	public String getBearable() {
		return bearable;
	}

	public void setBearable(String bearable) {
		this.bearable = bearable;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public BigDecimal getPlanFee() {
        return planFee;
    }

    public void setPlanFee(BigDecimal planFee) {
        this.planFee = planFee;
    }

    public Integer getDurationLimit() {
        return durationLimit;
    }

    public void setDurationLimit(Integer durationLimit) {
        this.durationLimit = durationLimit;
    }

    public Integer getDurationFree() {
        return durationFree;
    }

    public void setDurationFree(Integer durationFree) {
        this.durationFree = durationFree;
    }

    public Integer getTrafficLimit() {
        return trafficLimit;
    }

    public void setTrafficLimit(Integer trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    public Integer getTrafficFree() {
        return trafficFree;
    }

    public void setTrafficFree(Integer trafficFree) {
        this.trafficFree = trafficFree;
    }

    public Integer getOccuranceLimit() {
        return occuranceLimit;
    }

    public void setOccuranceLimit(Integer occuranceLimit) {
        this.occuranceLimit = occuranceLimit;
    }

    public Integer getOccuranceFree() {
        return occuranceFree;
    }

    public void setOccuranceFree(Integer occuranceFree) {
        this.occuranceFree = occuranceFree;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc == null ? null : planDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    
    public String getPlanTypeDesc() {
    	if (planType == null) {
    		return "";
    	} else if (planType == 0) {
    		return "兜底套餐";
    	} else if (planType == 1) {
    		return "公共套餐";
    	} else {
    		return "私有套餐";
    	}
    }
    
    public String getTermDesc() {
    	if ("DAY".equals(term)) {
    		return "天";
    	} else if ("WEEK".equals(term)) {
    		return "周";
    	} else if ("MONTH".equals(term)) {
    		return "月";
    	} else if ("SEASON".equals(term)) {
    		return "季";
    	} else if ("HALFOFYEAR".equals(term)) {
    		return "半年";
    	} else {
    		return "年";
    	}
    }
    
    public String getStatusDesc() {
    	if (status == null) {
    		return "";
    	} else if (status == 0) {
    		return "创建";
    	} else if (status == 1) {
    		return "发布";
    	} else {
    		return "下线";
    	}
    }
}