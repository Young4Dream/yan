package com.tstar.ocs.model;

public class SidDataConfig {
    private String id;

    private String name;

    private Integer upSpeed;

    private Integer downSpeed;

    private Integer bandWidth;

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

    public Integer getUpSpeed() {
        return upSpeed;
    }

    public void setUpSpeed(Integer upSpeed) {
        this.upSpeed = upSpeed;
    }

    public Integer getDownSpeed() {
        return downSpeed;
    }

    public void setDownSpeed(Integer downSpeed) {
        this.downSpeed = downSpeed;
    }

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}