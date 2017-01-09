package com.tstar.billing.collect;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.tstar.billing.business.CdrLogBus;
import com.tstar.billing.business.ProfileBus;
import com.tstar.billing.model.IMessageQueue;
import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileInfo;
import com.tstar.util.Log;

public abstract class CollectThread extends Thread {

	private final long sleepDuration = ProfileBus.getCollectInterval() * 1000;
	protected CdrSource source;
	protected boolean isRunning = false; 
	//private MQ queue;
	//private IMessageQueue queue = new DBMessageQueue();
	private IMessageQueue queue = new BlockingMessageQueue();
	private CdrSource cache = null;
	
	public CollectThread(CdrSource source) {
		super();
		this.source = source;
	}
	
	public void setResource(CdrSource value) {
		source.setStatus(value.getStatus());
		cache = value;
	}
	
	public String getSourceId() {
		return source.getId();
	}
	
	public Integer getSourceStatus() {
		return source.getStatus();
	}
	
	public String getProtocol() {
		return source.getProtocol();
	}
	
	public boolean getIsRunning() {
		return isRunning;
	}
	
	public void stopCollect() {
		source.setStatus(CdrSource.STATUS_DISABLED);
		Log.getLogger().info("Stopping the CDR Collect thread: " + source.getName());
		// Waiting until the thread stopped.
		while (isRunning) {
			try { Thread.sleep(1000); } catch (Exception e) {}
		}
	}

	protected abstract void connect() throws Exception;
	protected abstract void disconnect();
	protected abstract List<FileInfo> collect() throws Exception;
	protected abstract int process(List<FileInfo> list);
	
	protected void sendMessage(Serializable obj) throws Exception {
		try {
			queue.send(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	protected String getCachedDirectory() {
		String path = source.getCachedDirectory() + System.getProperty("file.separator") 
			+ source.getName() + System.getProperty("file.separator");
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}
	
	protected String getArchiveDirectory() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String path = source.getArchiveDirectory() + System.getProperty("file.separator")
		  + source.getName() + System.getProperty("file.separator")
		  + sdf.format(new Date()) + System.getProperty("file.separator");
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}
	
	/**
	 * 检查文件是否变动
	 * @param fileInfo
	 * @return
	 * 	全量采集模式，返回0
	 * 	增量采集模式，并且文件大小和尺寸和最后一次采集相同，返回-1
	 * 	增量采集模式，并且文件大小和尺寸和最后一次采集不同，返回最后一次采集文件的字节数
	 */
	protected int getLastFileSize(FileInfo fileInfo) {
		if (CdrSource.COLLECT_MODE_INCREMENT == source.getCollectMode()) {
			// 增量采集模式，验证忽略还是继续分拣
			CdrLog log = CdrLogBus.getLastLog(source.getId(), fileInfo.getName());
			if (log == null || log.getFileSize() == null) return 0;
			if ((int)log.getFileSize() == fileInfo.getSize().intValue() &&
				(int)log.getCheckSum() == fileInfo.getCheckSum().intValue()) {
				Log.getLogger().debug("File is not changed and ignored: " + fileInfo.getName());
				return -1;
			} else {
				return (int)log.getFileSize();
			}
		}
		return 0;
	}
	
	private void suspend(long duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			
		}
	}
	
	public void run() {
		Log.getLogger().info("Start polling network element, host=" + source.getHost() 
				+ ", protocol=" + source.getProtocol() 
				+ ", directory=" + source.getSourceDirectory()); 
		isRunning = true;
		while(source.getStatus() == CdrSource.STATUS_ENABLED) {
			if (cache != null) {
				source = cache;
				cache = null;
			}
			try {
				connect();
				List<FileInfo> list = collect();
				if (list != null && list.size() > 0) {
					int count = process(list);
					if (count > 0) {
						Log.getLogger().info("Finding " + count + " files to be collecting in the network element, name=" + source.getName());
					}
				}
				//Log.getLogger().info("Finding " + (list==null ? 0 :list.size()) + " files to be collecting in the network element, name=" + source.getName());
				disconnect();
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
			suspend(sleepDuration);
		}
		queue.disconnect();
		isRunning = false;
		Log.getLogger().info("Stop polling network element, host=" + source.getHost() 
				+ ", protocol=" + source.getProtocol() 
				+ ", directory=" + source.getSourceDirectory()); 
	}
}
