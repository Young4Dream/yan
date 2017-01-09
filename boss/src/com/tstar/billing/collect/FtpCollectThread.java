/**
 * 
 */
package com.tstar.billing.collect;

import java.util.List;

import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileInfo;
import com.tstar.util.Ftp;
import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class FtpCollectThread extends CollectThread {

	private Ftp ftp;
	
	public FtpCollectThread(CdrSource source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see com.tsd.cdr.collect.CollectThread#collect()
	 */
	@Override
	protected List<FileInfo> collect() throws Exception {
		if (!ftp.isConnected()) {
			connect();
		}
		return ftp.list(null, source.getFilenamePattern());
	}

	/* (non-Javadoc)
	 * @see com.tsd.cdr.collect.CollectThread#connect()
	 */
	@Override
	protected void connect() throws Exception {
		ftp = new Ftp();
		int port = source.getPort();
		//String pwd = AESUtil.decryptWrap(source.getPwd());
		//String pwd = EncryptTool.decrypt(source.getPwd());
		String pwd = source.getPwd();
		ftp.connect(source.getHost(), source.getUserName(), pwd, port, source.getSourceDirectory());
	}

	/* (non-Javadoc)
	 * @see com.tsd.cdr.collect.CollectThread#disconnect()
	 */
	@Override
	protected void disconnect() {
		if (ftp == null)
			return;
		ftp.disconnect();

	}

	/* (non-Javadoc)
	 * @see com.tsd.cdr.collect.CollectThread#process(java.util.List)
	 */
	@Override
	protected int process(List<FileInfo> list) {
		int count = 0;
		if (list == null) return 0;
		for (int i = 0; i < list.size(); i++) {
			try {
				FileInfo fileInfo = list.get(i);
				String fileName = fileInfo.getName();
				int lastFileSize = getLastFileSize(fileInfo);
				if (0 > lastFileSize) {
					continue;
				}
				count++;
				String filePath = source.getSourceDirectory() + System.getProperty("file.separator") + fileName;
				String cachedFileName = getCachedDirectory() + fileName;
				String archiveFileName = getArchiveDirectory() + fileName;
				ftp.download(fileName, cachedFileName);
				CdrLog obj = new CdrLog(source.getHost(), fileName,
						source.getSourceDirectory(), cachedFileName, archiveFileName,
						source.getDecoderName());
				obj.setSourceId(source.getId());
				obj.setSourceName(source.getName());
				obj.setCollectMode(source.getCollectMode());
				obj.setLastFileSize(lastFileSize);
				obj.setFileSize(fileInfo.getSize().intValue());
				obj.setCheckSum(fileInfo.getCheckSum());
				sendMessage(obj);
				if (source.getCollectMode() == null || source.getCollectMode() == CdrSource.COLLECT_MODE_WHOLE) {
					// 全量采集模式，删除源文件
					ftp.rm(fileName);
				}
				Log.getLogger().info("Move " + filePath + " from " + source.getHost() + " to " + cachedFileName + " via ftp");
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}
		return count;
	}

}
