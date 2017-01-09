package com.tstar.ocs.model;

public class SidVoiceConfigItem {
    private String id;

    private String configId;

    private String callerPrefix;

    private String calleePrefix;

    private String calleeLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId == null ? null : configId.trim();
    }

    public String getCallerPrefix() {
        return callerPrefix;
    }

    public void setCallerPrefix(String callerPrefix) {
        this.callerPrefix = callerPrefix == null ? null : callerPrefix.trim();
    }

    public String getCalleePrefix() {
        return calleePrefix;
    }

    public void setCalleePrefix(String calleePrefix) {
        this.calleePrefix = calleePrefix == null ? null : calleePrefix.trim();
    }

    public String getCalleeLocation() {
        return calleeLocation;
    }

    public void setCalleeLocation(String calleeLocation) {
        this.calleeLocation = calleeLocation == null ? null : calleeLocation.trim();
    }
}