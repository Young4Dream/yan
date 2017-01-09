package com.tstar.portal.model;

public class SysBusinessOp {
    private String id;

    private String busiKey;

    private String name;

    private String modelKey;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBusiKey() {
        return busiKey;
    }

    public void setBusiKey(String busiKey) {
        this.busiKey = busiKey == null ? null : busiKey.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey == null ? null : modelKey.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}