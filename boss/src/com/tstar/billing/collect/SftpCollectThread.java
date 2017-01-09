package com.tstar.billing.collect;

import java.util.List;

import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileInfo;
import com.tstar.util.Log;
import com.tstar.util.Sftp;

public final class SftpCollectThread extends CollectThread {

	private Sftp sftp;
	
	public SftpCollectThread(CdrSource source) {
		super(source);
	}
	
	@Override
	protected void connect() throws Exception {
		sftp = new Sftp();
		int port = source.getPort();
		//String pwd = AESUtil.decryptWrap(source.getPwd());
		//String pwd = EncryptTool.decrypt(source.getPwd());
		String pwd = source.getPwd();
		sftp.connect(source.getHost(), source.getUserName(), pwd, port, source.getSourceDirectory());
	}

	@Override
	protected void disconnect() {
		if (sftp == null)
			return;
		sftp.disconnect();
	}

	@Override
	protected List<FileInfo> collect() throws Exception {
		if (!sftp.isConnected()) {
			connect();
		}
		return sftp.list(source.getSourceDirectory(), source.getFilenamePattern());
	}

	@Override
	protected int process(List<FileInfo> list) {
		int count = 0;
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
				sftp.download(null, fileName, cachedFileName);
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
					sftp.rm(fileName);
				}
				Log.getLogger().info("Move " + filePath + " from " + source.getHost() + " to " + cachedFileName + " via sftp");
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}
		return count;
	}

	public static void main(String args[]) {
		Sftp server = new Sftp();
		try {
			server.connect("192.168.44.216", "root", "cnp200@HW", 22, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
