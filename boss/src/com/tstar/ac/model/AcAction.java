package com.tstar.ac.model;

import java.util.Date;

public class AcAction {
	
	public static final int STATUS_NORMAL = 1;
	public static final int STATUS_INIT = 0;
	public static final int STATUS_EXE = 2;
	public static final int STATUS_SUCCESS = 9;
	public static final int STATUS_NO_COMMANDS = 91;
	public static final int STATUS_RETRY = 98;
	public static final int STATUS_FAIL = 99;
	
    private String id;

    private String userId;

    private String businessKey;

    private String businessType;

    private String jobId;

    private String ossKey;

    private String parms;

    private Integer status;

    private Integer retry;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey == null ? null : businessKey.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getOssKey() {
        return ossKey;
    }

    public void setOssKey(String ossKey) {
        this.ossKey = ossKey == null ? null : ossKey.trim();
    }

    public String getParms() {
        return parms;
    }

    public void setParms(String parms) {
        this.parms = parms == null ? null : parms.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
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
    
    private String ossKeyName;

	public String getOssKeyName() {
		return ossKeyName;
	}

	public void setOssKeyName(String ossKeyName) {
		this.ossKeyName = ossKeyName;
	}
	
	public String getStatusDesc() {
		if (status == null) {
			return "";
		} else if (0 == status) {
			return "确认";
		} else if (1 == status) {
			return "生成指令";
		} else if (2 == status) {
			return "执行";
		} else if (9 == status) {
			return "完成";
		} else if (91 == status) {
			return "空指令";
		} else if (98 == status) {
			return "失败重试";
		} else if (99 == status){
			return "失败";
		} else {
			return "";
		}
	}
}