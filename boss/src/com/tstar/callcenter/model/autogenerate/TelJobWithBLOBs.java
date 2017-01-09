package com.tstar.callcenter.model.autogenerate;

public class TelJobWithBLOBs extends TelJob {
    private String bz;

    private String pgrz;

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getPgrz() {
        return pgrz;
    }

    public void setPgrz(String pgrz) {
        this.pgrz = pgrz == null ? null : pgrz.trim();
    }
}