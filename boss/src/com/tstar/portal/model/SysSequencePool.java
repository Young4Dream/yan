package com.tstar.portal.model;

import java.util.Date;

public class SysSequencePool {
    private String id;

    private String policyKey;

    private String currPrefix;

    private String currVal;

    private Integer locked;

    private Date lockTime;

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

    public String getCurrPrefix() {
        return currPrefix;
    }

    public void setCurrPrefix(String currPrefix) {
        this.currPrefix = currPrefix == null ? null : currPrefix.trim();
    }

    public String getCurrVal() {
        return currVal;
    }

    public void setCurrVal(String currVal) {
        this.currVal = currVal == null ? null : currVal.trim();
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}