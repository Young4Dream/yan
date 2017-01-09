package com.tstar.callcenter.model.autogenerate;

public class KnowledgeClass {
    private Long klcId;

    private String klcName;

    private Long klcParentid;

    private Long klcOrder;

    public Long getKlcId() {
        return klcId;
    }

    public void setKlcId(Long klcId) {
        this.klcId = klcId;
    }

    public String getKlcName() {
        return klcName;
    }

    public void setKlcName(String klcName) {
        this.klcName = klcName == null ? null : klcName.trim();
    }

    public Long getKlcParentid() {
        return klcParentid;
    }

    public void setKlcParentid(Long klcParentid) {
        this.klcParentid = klcParentid;
    }

    public Long getKlcOrder() {
        return klcOrder;
    }

    public void setKlcOrder(Long klcOrder) {
        this.klcOrder = klcOrder;
    }
}