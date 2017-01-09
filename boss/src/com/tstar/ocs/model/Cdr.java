package com.tstar.ocs.model;

import java.math.BigDecimal;
import java.util.Date;

public class Cdr {
	public final static int STATUS_INIT = 0;
	public final static int STATUS_PRICING = 1;
	public final static int STATUS_BILLING = 2;
	public final static int STATUS_FINISHED = 9;
	
	public Cdr() {}
	
	public Cdr(Cdr obj) {
		this.id = obj.id;
		this.caller = obj.caller;
		this.callee = obj.callee;
		this.startTime = obj.startTime;
		this.endTime = obj.endTime;
		this.duration = obj.duration;
		this.trunkGroupIn = obj.trunkGroupIn;
		this.trunkGroupOut = obj.trunkGroupOut;
	}
	
    private String id;

    private String userId;
    
    private String customerId;
    
    private String userName;

    private String caller;

    private String callee;

    private Date startTime;

    private Date endTime;

    private Integer duration;

    private String trunkGroupIn;

    private String trunkGroupOut;

    private String callerLocation;

    private String calleeLocation;

    private String callType;

    private String serviceAbbr;
    
    private String serviceId;

    private String pricePlanId;

    private String rateId;

    private BigDecimal price;

    private Integer usageCount;

    private Integer freeUsage;

    private Integer chargingUsage;

    private BigDecimal fee;

    private BigDecimal discount;

    private BigDecimal debitPrice;

    private String debitor;

    private String billId;

    private String billAccNo;

    private String logId;

    private Integer abnormalCode;

    private String abnormalDesc;

    private Integer hashCode;

    private Date createTime;

    private Date updateTime;
    
    private BigDecimal attachPrice;
    private Integer attachUsage;
    private BigDecimal attachFee;
    private BigDecimal totalFee;
    
    private Integer status;
    
    private String sourceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
    }

    public String getCallee() {
        return callee;
    }

    public void setCallee(String callee) {
        this.callee = callee == null ? null : callee.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getTrunkGroupIn() {
        return trunkGroupIn;
    }

    public void setTrunkGroupIn(String trunkGroupIn) {
        this.trunkGroupIn = trunkGroupIn == null ? null : trunkGroupIn.trim();
    }

    public String getTrunkGroupOut() {
        return trunkGroupOut;
    }

    public void setTrunkGroupOut(String trunkGroupOut) {
        this.trunkGroupOut = trunkGroupOut == null ? null : trunkGroupOut.trim();
    }

    public String getCallerLocation() {
        return callerLocation;
    }

    public void setCallerLocation(String callerLocation) {
        this.callerLocation = callerLocation == null ? null : callerLocation.trim();
    }

    public String getCalleeLocation() {
        return calleeLocation;
    }

    public void setCalleeLocation(String calleeLocation) {
        this.calleeLocation = calleeLocation == null ? null : calleeLocation.trim();
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public String getServiceAbbr() {
        return serviceAbbr;
    }

    public void setServiceAbbr(String serviceAbbr) {
        this.serviceAbbr = serviceAbbr == null ? null : serviceAbbr.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getPricePlanId() {
        return pricePlanId;
    }

    public void setPricePlanId(String pricePlanId) {
        this.pricePlanId = pricePlanId == null ? null : pricePlanId.trim();
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId == null ? null : rateId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    public Integer getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(Integer freeUsage) {
        this.freeUsage = freeUsage;
    }

    public Integer getChargingUsage() {
        return chargingUsage;
    }

    public void setChargingUsage(Integer chargingUsage) {
        this.chargingUsage = chargingUsage;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDebitPrice() {
        return debitPrice;
    }

    public void setDebitPrice(BigDecimal debitPrice) {
        this.debitPrice = debitPrice;
    }

    public String getDebitor() {
        return debitor;
    }

    public void setDebitor(String debitor) {
        this.debitor = debitor == null ? null : debitor.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getBillAccNo() {
        return billAccNo;
    }

    public void setBillAccNo(String billAccNo) {
        this.billAccNo = billAccNo == null ? null : billAccNo.trim();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public Integer getAbnormalCode() {
        return abnormalCode;
    }

    public void setAbnormalCode(Integer abnormalCode) {
        this.abnormalCode = abnormalCode;
    }

    public String getAbnormalDesc() {
        return abnormalDesc;
    }

    public void setAbnormalDesc(String abnormalDesc) {
        this.abnormalDesc = abnormalDesc == null ? null : abnormalDesc.trim();
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
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
    
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    
    public BigDecimal getAttachPrice() { return attachPrice; }
    public void setAttachPrice(BigDecimal attachPrice) { this.attachPrice = attachPrice; }
    
    public Integer getAttachUsage() { return attachUsage; }
    public void setAttachUsage(Integer attachUsage) { this.attachUsage = attachUsage; }
    
    public BigDecimal getAttachFee() { return attachFee; }
    public void setAttachFee(BigDecimal attachFee) { this.attachFee = attachFee; }
    
    public BigDecimal getTotalFee() { return totalFee; }
    public void setTotalFee(BigDecimal totalFee) { this.totalFee = totalFee; }
    
    @Override
    public int hashCode() {
    	return (caller + "-" + callee + "-" + startTime.toString() + "-" + duration).hashCode();
    }
    
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof Cdr) {
			Cdr key = (Cdr)obj;
			flag = this.getCaller().equals(key.getCaller()) &&
				   this.getCallee().equals(key.getCallee()) &&
				   this.getDuration().equals(key.getDuration()) &&
				   this.getStartTime().getTime() == key.getStartTime().getTime();
				   
		}
		return flag;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
    
    
}