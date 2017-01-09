package com.tstar.billing.collect;

import java.io.File;
import java.util.List;

import com.tstar.ocs.model.CdrLog;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileHelper;
import com.tstar.util.FileInfo;
import com.tstar.util.Log;

public final class LocalCollectThread extends CollectThread {

	public LocalCollectThread(CdrSource source) {
		super(source);
	}
	
	@Override
	protected void connect() {}

	@Override
	protected void disconnect() {}

	@Override
	protected List<FileInfo> collect() {
		return FileHelper.listFiles(source.getSourceDirectory(), source.getFilenamePattern());
	}

	@Override
	protected int process(List<FileInfo> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i ++) {
			try {
				FileInfo fileInfo = list.get(i);
				int lastFileSize = getLastFileSize(fileInfo);
				if (0 > lastFileSize) {
					continue;
				}
				count++;
				String fileName = fileInfo.getName();
				String filePath = source.getSourceDirectory() + System.getProperty("file.separator") + fileName;
				String cachedFileName = getCachedDirectory() + fileName;
				String archiveFileName = getArchiveDirectory() + fileName;
				FileHelper.copy(filePath, cachedFileName);
				File file = new File(filePath);
				if (source.getCollectMode() == null || source.getCollectMode() == CdrSource.COLLECT_MODE_WHOLE) {
					// 全量采集模式，删除源文件
					file.delete();
				}
				Log.getLogger().info("Move " + filePath + " to " + cachedFileName);
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
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}
		return count;
	}

}
