package com.tstar.res.model;

public class ResBillingArea {
    private String id;

    private String billingArea;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillingArea() {
        return billingArea;
    }

    public void setBillingArea(String billingArea) {
        this.billingArea = billingArea == null ? null : billingArea.trim();
    }
}