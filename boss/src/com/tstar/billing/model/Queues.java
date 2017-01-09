/**
 * 
 */
package com.tstar.billing.model;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.tstar.billing.business.CdrBus;
import com.tstar.billing.business.CdrLogBus;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

/**
 * @author zhumengfeng
 *
 */
public class Queues {
	// Decoding queue
	public static LinkedBlockingQueue<CdrLog> queueDecoding = new LinkedBlockingQueue<CdrLog>();
	
	// Pricing queue
	public static LinkedBlockingQueue<Job> queuePricing = new LinkedBlockingQueue<Job>();
	
	// Billing queue
	public static LinkedBlockingQueue<Job> queueBilling = new LinkedBlockingQueue<Job>();
	
	public static void initQueueDecoding() throws Exception {
		List<CdrLog> logs = CdrLogBus.getSortingLogs(CdrLog.STATUS_INIT);
		for (CdrLog log : logs) {
			Queues.queueDecoding.put(log);
		}
	}
	
	public static void initQueuePricing() throws Exception {
		List<CdrLog> logs = CdrLogBus.getSortingLogs(CdrLog.STATUS_PRICING);
		for (CdrLog log : logs) {
			List<Cdr> cdrs = CdrBus.getSortingCdrs(log.getId(), Cdr.STATUS_PRICING);
			Job job = new Job(log, cdrs);
			Queues.queuePricing.put(job);
		}
	}
	
	public static void initQueueBilling() throws Exception {
		List<CdrLog> logs = CdrLogBus.getSortingLogs(CdrLog.STATUS_BILLING);
		for (CdrLog log : logs) {
			List<Cdr> cdrs = CdrBus.getSortingCdrs(log.getId(), Cdr.STATUS_BILLING);
			Job job = new Job(log, cdrs);
			Queues.queueBilling.put(job);
		}
	}
}
