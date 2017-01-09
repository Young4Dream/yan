package com.tstar.ocs.model;

import java.util.Date;

public class CdrSource {
	public final static int STATUS_DISABLED = 0;
	public final static int STATUS_ENABLED = 1;
	
	public final static int COLLECT_MODE_WHOLE = 1;
	public final static int COLLECT_MODE_INCREMENT = 2;
	
    private String id;

    private String name;

    private String protocol;

    private String host;

    private Integer port;

    private String userName;

    private String pwd;

    private String sourceDirectory;

    private String cachedDirectory;

    private String archiveDirectory;

    private String decoderName;

    private String filenamePattern;

    private Integer collectMode;

    private Integer status;

    private String creator;

    private Date createTime;

    private Date updateTime;

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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory == null ? null : sourceDirectory.trim();
    }

    public String getCachedDirectory() {
        return cachedDirectory;
    }

    public void setCachedDirectory(String cachedDirectory) {
        this.cachedDirectory = cachedDirectory == null ? null : cachedDirectory.trim();
    }

    public String getArchiveDirectory() {
        return archiveDirectory;
    }

    public void setArchiveDirectory(String archiveDirectory) {
        this.archiveDirectory = archiveDirectory == null ? null : archiveDirectory.trim();
    }

    public String getDecoderName() {
        return decoderName;
    }

    public void setDecoderName(String decoderName) {
        this.decoderName = decoderName == null ? null : decoderName.trim();
    }

    public String getFilenamePattern() {
        return filenamePattern;
    }

    public void setFilenamePattern(String filenamePattern) {
        this.filenamePattern = filenamePattern == null ? null : filenamePattern.trim();
    }

    public Integer getCollectMode() {
        return collectMode;
    }

    public void setCollectMode(Integer collectMode) {
        this.collectMode = collectMode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public String getStatusDesc() {
    	return status == 0 ? "失效" : "生效";
    }
}