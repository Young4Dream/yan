package com.tstar.ocs.model;

import java.io.Serializable;
import java.util.Date;

public class CdrLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public final static int STATUS_INIT = 0;
	public final static int STATUS_PRICING = 2;
	public final static int STATUS_BILLING = 3;
	public final static int STATUS_FINISHED = 9;
	public final static int STATUS_ABNORMAL = 10;
	
	public CdrLog() {}
	
	public CdrLog(String host, String filename, String source, String cached, String archive, String decoderName) {
		this.host = host;
		this.filename = filename;
		this.sourceDirectory = source;
		this.cachedDirectory = cached;
		this.archiveDirectory = archive;
		this.decoderName = decoderName;
		this.flag = STATUS_INIT;
		this.recordCount = 0;
		this.abnormalCount = 0;
		this.createTime = new Date();
	}

	private String id;
	
	private String sourceId;

    private String host;

    private String filename;
    
    private Integer fileSize;
    
    private Integer checkSum;

    private String sourceDirectory;

    private String cachedDirectory;

    private String archiveDirectory;

    private String decoderName;

    private Integer flag;

    private Integer recordCount;

    private Integer abnormalCount;

    private Date createTime;

    private Date updateTime;
    
    private Integer collectMode;
    
    private Integer lastFileSize;
    
    private String sourceName;

    public Integer getLastFileSize() {
    	if (lastFileSize == null) {
    		return 0;
    	} else {
    		return lastFileSize;
    	}
	}

	public void setLastFileSize(Integer lastFileSize) {
		this.lastFileSize = lastFileSize;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getAbnormalCount() {
        return abnormalCount;
    }

    public void setAbnormalCount(Integer abnormalCount) {
        this.abnormalCount = abnormalCount;
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
    
    public String getFlagDesc() {
    	if (flag == 0) {
    		return "采集";
    	} else if (flag == 1) {
    		return "解码";
    	} else if (flag == 2) {
    		return "批价";
    	} else if (flag == 3) {
    		return "累账";
    	} else if (flag == 9) {
    		return "完成";
    	} else {
    		return "失败";
    	}
    }

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(Integer checkSum) {
		this.checkSum = checkSum;
	}

	public Integer getCollectMode() {
		return collectMode;
	}

	public void setCollectMode(Integer collectMode) {
		this.collectMode = collectMode;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
}