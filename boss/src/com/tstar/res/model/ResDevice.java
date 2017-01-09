package com.tstar.res.model;

import java.util.Date;

public class ResDevice {
    private String id;

    private String deviceCode;

    private String name;

    private String deviceTypeId;

    private String manufacturer;

    private String deviceModel;

    private Date installDate;

    private String address;

    private String startPortCode;

    private String endPortCode;

    private String portDesc;

    private Integer portTotal;

    private String resDept;

    private String ctrlIp;

    private String ctrlProtocol;

    private String ctrlUserName;

    private String ctrlPwd;

    private String ctrlAdvUserName;

    private String ctrlAdvPwd;

    private String dataIp;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel == null ? null : deviceModel.trim();
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStartPortCode() {
        return startPortCode;
    }

    public void setStartPortCode(String startPortCode) {
        this.startPortCode = startPortCode == null ? null : startPortCode.trim();
    }

    public String getEndPortCode() {
        return endPortCode;
    }

    public void setEndPortCode(String endPortCode) {
        this.endPortCode = endPortCode == null ? null : endPortCode.trim();
    }

    public String getPortDesc() {
        return portDesc;
    }

    public void setPortDesc(String portDesc) {
        this.portDesc = portDesc == null ? null : portDesc.trim();
    }

    public Integer getPortTotal() {
        return portTotal;
    }

    public void setPortTotal(Integer portTotal) {
        this.portTotal = portTotal;
    }

    public String getResDept() {
        return resDept;
    }

    public void setResDept(String resDept) {
        this.resDept = resDept == null ? null : resDept.trim();
    }

    public String getCtrlIp() {
        return ctrlIp;
    }

    public void setCtrlIp(String ctrlIp) {
        this.ctrlIp = ctrlIp == null ? null : ctrlIp.trim();
    }

    public String getCtrlProtocol() {
        return ctrlProtocol;
    }

    public void setCtrlProtocol(String ctrlProtocol) {
        this.ctrlProtocol = ctrlProtocol == null ? null : ctrlProtocol.trim();
    }

    public String getCtrlUserName() {
        return ctrlUserName;
    }

    public void setCtrlUserName(String ctrlUserName) {
        this.ctrlUserName = ctrlUserName == null ? null : ctrlUserName.trim();
    }

    public String getCtrlPwd() {
        return ctrlPwd;
    }

    public void setCtrlPwd(String ctrlPwd) {
        this.ctrlPwd = ctrlPwd == null ? null : ctrlPwd.trim();
    }

    public String getCtrlAdvUserName() {
        return ctrlAdvUserName;
    }

    public void setCtrlAdvUserName(String ctrlAdvUserName) {
        this.ctrlAdvUserName = ctrlAdvUserName == null ? null : ctrlAdvUserName.trim();
    }

    public String getCtrlAdvPwd() {
        return ctrlAdvPwd;
    }

    public void setCtrlAdvPwd(String ctrlAdvPwd) {
        this.ctrlAdvPwd = ctrlAdvPwd == null ? null : ctrlAdvPwd.trim();
    }

    public String getDataIp() {
        return dataIp;
    }

    public void setDataIp(String dataIp) {
        this.dataIp = dataIp == null ? null : dataIp.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}