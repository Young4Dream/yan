/**
 * 话单分拣主程序
 * @author zhumengfeng
 * @version 1.0
 */
package com.tstar.billing;

import com.tstar.billing.biller.BillerThread;
import com.tstar.billing.collect.CollectDaemon;
import com.tstar.billing.decoder.DecodeThread;
import com.tstar.billing.model.Queues;
import com.tstar.billing.pricer.PricerThread;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

public class BillingApp {

	public static void main(String[] args) {
		// 在启动采集、批价、累账线程之前，检查是否存在异常退出的任务
		// 若有，重新进入队列，等待重新批价累账
		try {
			// Restore pricing
			Log.getLogger().info("Restoring pricing cdrs...");
			Queues.initQueuePricing();
			// Restore billing
			Log.getLogger().info("Restoring billing cdrs...");
			Queues.initQueueBilling();
		} catch (Exception e) {
			Log.getLogger().error(ExceptionUtil.getStackTrace(e));
		}
		
		// 启动采集DAEMON线程
		Thread th = new CollectDaemon();
		th.setName("CDR Collect Daemon");
		th.start();
		// 启动话单标准化线程
		Thread thDecoding = new Thread(new DecodeThread(), "Decoder");
		thDecoding.start();
		// 启动批价线程
		Thread thPricing = new Thread(new PricerThread(), "Pricer");
		thPricing.start();
		// 启动批价线程
		Thread thBiller = new Thread(new BillerThread(), "Biller");
		thBiller.start();
	}
}
