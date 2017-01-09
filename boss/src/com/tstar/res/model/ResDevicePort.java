package com.tstar.res.model;

public class ResDevicePort {
    private String id;

    private String deviceCode;

    private String portCode;

    private String status;

    private String bearable;
    
    private String bearing;
    
    private String parentDeviceCode;

    private String parentPortCode;

    private String businessKey;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode == null ? null : portCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentDeviceCode() {
        return parentDeviceCode;
    }

    public void setParentDeviceCode(String parentDeviceCode) {
        this.parentDeviceCode = parentDeviceCode == null ? null : parentDeviceCode.trim();
    }

    public String getParentPortCode() {
        return parentPortCode;
    }

    public void setParentPortCode(String parentPortCode) {
        this.parentPortCode = parentPortCode == null ? null : parentPortCode.trim();
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    private String statusDesc;
    
    public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String genBusinessesDesc(String businesses) {
    	if (businesses == null || "".equals(businesses)) {
    		return "";
    	} else {
    		String str = "";
    		for (int i = 0; i < businesses.length(); i++) {
    			if (!str.equals("")) {
    				str += "，";
    			}
    			str += genBusinessDesc(businesses.substring(i, i + 1));
    		}
    		return str;
    	}
    }

    private String genBusinessDesc(String key) {
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

	public String getBearable() {
		return bearable;
	}

	public void setBearable(String bearable) {
		this.bearable = bearable;
	}
	
	public String getBearableDesc() {
		return genBusinessesDesc(bearable);
	}

	public String getBearing() {
		return bearing;
	}

	public void setBearing(String bearing) {
		this.bearing = bearing;
	}
	
	public String getBearingDesc() {
		return genBusinessesDesc(bearing);
	}
	
	private String deviceName;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
    
}