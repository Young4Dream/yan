package com.tstar.res.model;

public class ResAddress {
    private String id;

    private String parentId;

    private String name;

    private String vlan;

    private String accPrefix;
    
    private String businessArea;
    
    private String userArea;

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

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan == null ? null : vlan.trim();
    }

    public String getAccPrefix() {
        return accPrefix;
    }

    public void setAccPrefix(String accPrefix) {
        this.accPrefix = accPrefix == null ? null : accPrefix.trim();
    }
}