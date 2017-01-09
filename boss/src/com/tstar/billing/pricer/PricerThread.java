/**
 * 
 */
package com.tstar.billing.pricer;

import java.util.Date;

import com.tstar.billing.business.CdrBus;
import com.tstar.billing.business.CdrLogBus;
import com.tstar.billing.decoder.DecoderConfig;
import com.tstar.billing.decoder.XMLDecoderConfig;
import com.tstar.billing.model.Job;
import com.tstar.billing.model.Queues;
import com.tstar.ocs.model.CdrLog;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class PricerThread implements Runnable {

	public void run() {
		while (true) {
			try {
				Job job = Queues.queuePricing.take();
				DecoderConfig config = XMLDecoderConfig.getDecoderConfig(job.log.getDecoderName());
				if (config == null) {
					Log.getLogger().error("Can not find decoder config, please check config file.");
					// Throw it away
					job.log.setFlag(CdrLog.STATUS_ABNORMAL);
					CdrLogBus.save(job.log);
					continue; 
				}
				
				long t1, t2;
				t1 = (new Date()).getTime();
				INumberFormatter formatter = XMLDecoderConfig.getNumberFormatter(config.formatter);
				if (formatter != null) {
					formatter.format(job.log, job.cdrs);
				}
				IPricer pricer = XMLDecoderConfig.getPricer(config.pricer);
				if (pricer != null) {
					pricer.format(job.log, job.cdrs);
					pricer.pricing(job.log, job.cdrs);
				}
				// save cdrs
				CdrBus.update(job.cdrs);
				// Update log status
				job.log.setFlag(CdrLog.STATUS_BILLING);
				CdrLogBus.save(job.log);
				// Send message
				Queues.queueBilling.put(job);
				t2 = (new Date()).getTime();
				Log.getLogger().info("Pricing CDRs, id=" + job.log.getId() + ", it takes " + (t2-t1) + " milliseconds.");
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}
	}

}
