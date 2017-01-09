/**
 * 
 */
package com.tstar.billing.decoder;

import java.util.Date;
import java.util.List;

import com.tstar.billing.business.CdrBus;
import com.tstar.billing.business.CdrLogBus;
import com.tstar.billing.model.Job;
import com.tstar.billing.model.Queues;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileHelper;
import com.tstar.util.Log;


/**
 * @author zhumengfeng
 *
 */
public class DecodeThread implements Runnable {

	public void run() {
		try {
			// Restore decoding
			Log.getLogger().info("Restoring decoding log...");
			Queues.initQueueDecoding();
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
		}
		
		while (true) {
			try {
				CdrLog log = Queues.queueDecoding.take();
				DecoderConfig config = XMLDecoderConfig.getDecoderConfig(log.getDecoderName());
				if (config == null) {
					Log.getLogger().error("Can not find decoder config, please check config file.");
					// Throw it away
					log.setFlag(CdrLog.STATUS_ABNORMAL);
					CdrLogBus.save(log);
					continue; 
				}
				long t1, t2;
				t1 = (new Date()).getTime();
				// Load class
				IDecoder decoder = XMLDecoderConfig.getDecoder(config.className);
				if (decoder == null) {
					Log.getLogger().error("Could not load " + config.className);
					// Throw it away
					log.setFlag(CdrLog.STATUS_ABNORMAL);
					CdrLogBus.save(log);
					continue;
				}
				// Decode
				decoder.setStartPos((int)log.getLastFileSize());
				List<Cdr> cdrs = decoder.decode(log.getCachedDirectory(), config);
				if (cdrs == null) {
					Log.getLogger().error("Could not get any cdr from file.");
					continue;
				}
				Log.getLogger().info("Found " + cdrs.size() + " cdrs.");
				// Filt 
				IFilter filter = XMLDecoderConfig.getFilter(config.filter);
				if (filter != null) {
					filter.filt(cdrs);
				}
				Log.getLogger().info("After filting, there are " + cdrs.size() + " cdrs.");
				t2 = (new Date()).getTime();
				Log.getLogger().info("Decode CDR file, id=" + log.getId() + ", path=" + log.getCachedDirectory() + ", it takes " + (t2 - t1) + " milliseconds.");
				// Standard
				t1 = t2;
				log.setRecordCount(cdrs.size());
				//StdCDR.format(log, cdrs);
				t2 = (new Date()).getTime();
				//Log.getLogger().info("Prehandle CDRs, id=" + log.getId() + ", count=" + log.getRecordCount() + ", abnormalCount=" + log.getAbnormalCount() + ", it takes " + (t2 - t1) + " milliseconds.");
				// Save cdrs
				t1 = t2;
				CdrBus.clearSortingCdrs(log.getId()); 
				CdrBus.insert(cdrs);
				t2 = (new Date()).getTime();
				Log.getLogger().info("Save CDRs, id=" + log.getId() + ", it takes " + (t2-t1) + " milliseconds.");
				// Save log
				log.setFlag(CdrLog.STATUS_PRICING);
				CdrLogBus.save(log);
				// Send message
				Job job = new Job(log, cdrs);
				Queues.queuePricing.put(job);
				// Archive file
				FileHelper.move(log.getCachedDirectory(), log.getArchiveDirectory());
				Log.getLogger().info("Archive CDR file, id=" + log.getId() + ", path=" + log.getArchiveDirectory());
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}
	}

}
