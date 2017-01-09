package com.tstar.ocs.model;

public class SidServiceCategory {
    private String id;

    private String name;
    
    private String abbr;

    private String busType;

    private String meter;

    private String meterName;

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

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter == null ? null : meter.trim();
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName == null ? null : meterName.trim();
    }
    
    private String busTypeDesc;
    
    public String getBusTypeDesc() {
		return busTypeDesc;
	}

	public void setBusTypeDesc(String busTypeDesc) {
		this.busTypeDesc = busTypeDesc;
	}

	public String getMeterDesc() {
    	if ("T".equals(meter)) {
    		return "时长";
    	} else if ("D".equals(meter)) {
    		return "数据";
    	} else {
    		return "次数";
    	}
    }
}