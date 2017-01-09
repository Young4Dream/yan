package com.tstar.ocs.model;

public class SidOp {
    private String id;

    private String name;

    private String alias;

    private String remark;
    
    private String modelKey;

    public String getModelKey() {
		return modelKey;
	}

	public void setModelKey(String modelKey) {
		this.modelKey = modelKey;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    private String feeItems;
    public String getFeeItems() { return feeItems; }
    public void setFeeItems(String feeItems) { this.feeItems = feeItems; }
    
}