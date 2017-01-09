package com.tstar.res.model;

public class ResDeviceType {
    private String id;

    private String name;

    private String codePrefix;

    private Integer codeLen;

    private String bearBusiness;
    
    private String ctrlSetName;

    private String deviceIcon;

    private String remark;

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

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix == null ? null : codePrefix.trim();
    }

    public Integer getCodeLen() {
        return codeLen;
    }

    public void setCodeLen(Integer codeLen) {
        this.codeLen = codeLen;
    }

    public String getBearBusiness() {
        return bearBusiness;
    }

    public void setBearBusiness(String bearBusiness) {
        this.bearBusiness = bearBusiness == null ? null : bearBusiness.trim();
    }

    public String getDeviceIcon() {
        return deviceIcon;
    }

    public void setDeviceIcon(String deviceIcon) {
        this.deviceIcon = deviceIcon == null ? null : deviceIcon.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public String getBearBusinessDesc() {
    	if (bearBusiness == null || "".equals(bearBusiness)) {
    		return "";
    	} else {
    		String str = "";
    		for (int i = 0; i < bearBusiness.length(); i++) {
    			if (!str.equals("")) {
    				str += "，";
    			}
    			str += getBusinessDesc(bearBusiness.substring(i, i + 1));
    		}
    		return str;
    	}
    }
    
    private String getBusinessDesc(String key) {
    	if ("p".equals(key)) {
    		return "电话";
    	} else if ("b".equals(key)) {
    		return "宽带";
    	} else if ("a".equals(key)) {
    		return "ADSL";
    	} else if ("l".equals(key)) {
    		return "专线";
    	} else {
    		return "";
    	}
    }

	public String getCtrlSetName() {
		return ctrlSetName;
	}

	public void setCtrlSetName(String ctrlSetName) {
		this.ctrlSetName = ctrlSetName;
	}
    
}