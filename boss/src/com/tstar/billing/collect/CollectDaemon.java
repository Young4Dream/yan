package com.tstar.billing.collect;

import java.util.ArrayList;
import java.util.List;

import com.tstar.billing.business.CdrSourceBus;
import com.tstar.ocs.model.CdrSource;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

public class CollectDaemon extends Thread {
	
	private final static long SLEEP_DURATION = 5000L; // millisecond
	
	private List<CollectThread> threads = new ArrayList<CollectThread>();
	
	private CollectThread getThread(String sourceId) {
		for (CollectThread th : threads) {
			if (sourceId.equals(th.getSourceId())) {
				return th;
			}
		}
		return null;
	}
	
	private void removeThread(String sourceId) {
		int index = -1;
		for (int i = 0; i < threads.size(); i++) {
			if (sourceId.equals(threads.get(i).getSourceId())) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			threads.remove(index);
		}
	}
	
	private List<CdrSource> getEnabledSources() throws Exception {
		return CdrSourceBus.getEnabledSources();
	}
	
	private List<CdrSource> getAllSources() throws Exception {
		return CdrSourceBus.getAllSources();
	}
	
	private void suspend(long duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage());
		}
	}
	
	private CollectThread createThread(CdrSource source) {
		CollectThread th = null;
		String protocol = source.getProtocol().toLowerCase();
		if (protocol.equals("local")) {
			th = new LocalCollectThread(source);
			th.setName(source.getName() + " CDR Collect");
		} else if (protocol.equals("sftp")) {
			th = new SftpCollectThread(source);
			th.setName(source.getName() + " CDR Collect");
		} else if (protocol.equals("ftp")) {
			th = new FtpCollectThread(source);
			th.setName(source.getName() + " CDR Collect");
		} else {
			Log.getLogger().error("Unknown protocol:" + protocol);
		}
		if (th != null) {
			threads.add(th);
			th.start();
		}						
		return th;
	}
	
	public void run() {
		List<CdrSource> rs = null;
		// Maintain threads
		while (true) { try {
			if (rs == null) {
				// initialize threads
				rs = getEnabledSources();
				if (rs != null) {
					for (CdrSource r : rs) {
						createThread(r);
					}	
				}
			}
			
			suspend(SLEEP_DURATION);
			
			List<CdrSource> sources = getAllSources();
			for (CollectThread th : threads) {
				boolean existing = false;
				String id = th.getSourceId();
				for (CdrSource s : sources) {
					if (id.equals(s.getId())) {
						existing = true;
						break;
					}
				}
				if (!existing) {
					th.stopCollect();
				}
			}
			
			for (CdrSource source : sources) {
				CollectThread th = getThread(source.getId());
				if (th == null) {
					// This is a new source, create and start collect thread
					if (source.getStatus() == CdrSource.STATUS_ENABLED) {
						// Create and start collect thread
						th = createThread(source);
					}
				} else {
					// It is an existing source, start/stop the thread
					if (source.getStatus() == CdrSource.STATUS_ENABLED) {
						if (th.getSourceStatus() == CdrSource.STATUS_ENABLED) {
							// Judge if the thread need restart
							if (source.getProtocol().equals(th.getProtocol())) {
								th.setResource(source);
							} else {
								// Restart the thread
								th.stopCollect();
								removeThread(source.getId());
								th = createThread(source);
							}
						} else {
							// Kill the old thread, create and start a new collect thread
							removeThread(source.getId());
							th = createThread(source);
						}
					} else {
						// Stop the thread
						if (th.getSourceStatus() == CdrSource.STATUS_ENABLED) {
							th.stopCollect();
						}
					}
				} // else
			} // for (CdrSource source : sources) 
			
		} catch (Exception e) {
			Log.getLogger().info(ExceptionUtil.getStackTrace(e));
		} } // try...catch // while (true)
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread th = new CollectDaemon();
		th.setName("CDR Collect Daemon");
		th.start();
	}

}
