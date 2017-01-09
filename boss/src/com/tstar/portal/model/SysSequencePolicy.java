package com.tstar.portal.model;

public class SysSequencePolicy {
    private String id;

    private String policyKey;

    private String policyName;

    private String policyExp;

    private String currPrefix;

    private String currSeq;

    private Integer bufferSize;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPolicyKey() {
        return policyKey;
    }

    public void setPolicyKey(String policyKey) {
        this.policyKey = policyKey == null ? null : policyKey.trim();
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName == null ? null : policyName.trim();
    }

    public String getPolicyExp() {
        return policyExp;
    }

    public void setPolicyExp(String policyExp) {
        this.policyExp = policyExp == null ? null : policyExp.trim();
    }

    public String getCurrPrefix() {
        return currPrefix;
    }

    public void setCurrPrefix(String currPrefix) {
        this.currPrefix = currPrefix == null ? null : currPrefix.trim();
    }

    public String getCurrSeq() {
        return currSeq;
    }

    public void setCurrSeq(String currSeq) {
        this.currSeq = currSeq == null ? null : currSeq.trim();
    }

    public Integer getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}