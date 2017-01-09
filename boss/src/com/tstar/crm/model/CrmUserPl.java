package com.tstar.crm.model;

public class CrmUserPl {
    private String id;

    private String plNo;

    private String plType;

    private String plModel;

    private String startEp;

    private String endEp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlNo() {
        return plNo;
    }

    public void setPlNo(String plNo) {
        this.plNo = plNo == null ? null : plNo.trim();
    }

    public String getPlType() {
        return plType;
    }

    public void setPlType(String plType) {
        this.plType = plType == null ? null : plType.trim();
    }

    public String getPlModel() {
        return plModel;
    }

    public void setPlModel(String plModel) {
        this.plModel = plModel == null ? null : plModel.trim();
    }

    public String getStartEp() {
        return startEp;
    }

    public void setStartEp(String startEp) {
        this.startEp = startEp == null ? null : startEp.trim();
    }

    public String getEndEp() {
        return endEp;
    }

    public void setEndEp(String endEp) {
        this.endEp = endEp == null ? null : endEp.trim();
    }
    
    /////////////////////////////////////////////////////////
    private String plTypeDesc;

	public String getPlTypeDesc() {
		return plTypeDesc;
	}

	public void setPlTypeDesc(String plTypeDesc) {
		this.plTypeDesc = plTypeDesc;
	}
    
}