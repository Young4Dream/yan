/**
 * 
 */
package com.tstar.billing.biller;

import java.util.Date;

import com.tstar.billing.business.CdrLogBus;
import com.tstar.billing.model.Job;
import com.tstar.billing.model.Queues;
import com.tstar.ocs.model.CdrLog;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class BillerThread implements Runnable {

	public void run() {
		while (true) {
			try {
				Job job  = Queues.queueBilling.take();
				long t1, t2;
				t1 = (new Date()).getTime();
				IBiller biller = GeneralBiller.getDefaultBiller();
				biller.billing(job.cdrs);
				job.log.setFlag(CdrLog.STATUS_FINISHED); // over
				CdrLogBus.save(job.log);
				t2 = (new Date()).getTime();
				Log.getLogger().info("Billing CDRs, id=" + job.log.getId() + ", it takes " + (t2-t1) + " milliseconds.");
			} catch (Exception e) {
				Log.getLogger().error(ExceptionUtil.getStackTrace(e));
			}
		}

	}

}
