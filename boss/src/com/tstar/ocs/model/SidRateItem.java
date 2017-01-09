package com.tstar.ocs.model;

import java.math.BigDecimal;

public class SidRateItem {
    private String id;

    private String rateId;

    private BigDecimal price;

    private Integer baseDuration;

    private BigDecimal baseFee;

    private Integer baseUsage;

    private Integer threshold;
    
    private BigDecimal attachPrice;
    
    private Integer attachUnitCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}