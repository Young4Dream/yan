package com.tstar.ac.model;

import java.util.Date;

public class AcCommand {
    private String id;

    private String actionId;

    private String deviceCode;

    private String ctrlSetName;

    private String cmd;

    private Integer cmdOrder;

    private Integer keyFlag;

    private Integer retCode;

    private String retDesc;

    private Date exeTime;

    private String cmdPrompt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId == null ? null : actionId.trim();
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getCtrlSetName() {
        return ctrlSetName;
    }

    public void setCtrlSetName(String ctrlSetName) {
        this.ctrlSetName = ctrlSetName == null ? null : ctrlSetName.trim();
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd == null ? null : cmd.trim();
    }

    public Integer getCmdOrder() {
        return cmdOrder;
    }

    public void setCmdOrder(Integer cmdOrder) {
        this.cmdOrder = cmdOrder;
    }

    public Integer getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(Integer keyFlag) {
        this.keyFlag = keyFlag;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc == null ? null : retDesc.trim();
    }

    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }

    public String getCmdPrompt() {
        return cmdPrompt;
    }

    public void setCmdPrompt(String cmdPrompt) {
        this.cmdPrompt = cmdPrompt == null ? null : cmdPrompt.trim();
    }
}