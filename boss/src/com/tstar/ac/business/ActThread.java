/**
 * 生成线序和指令的线程
 */
package com.tstar.ac.business;

import com.tstar.ac.model.AcAction;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class ActThread extends Thread {

	private final static long SLEEP_DURATION = 2000L; // millisecond
	
	private void suspend(long duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage());
		}
	}
	
	public void run() {
		AcBus bus = new AcBus();
		while (true) {
			AcAction act = bus.getTopAction(AcAction.STATUS_NORMAL);
			if (act != null) {
				Log.getLogger().info("Getting top action, act.id=" + act.getId());
				try {
					bus.exeAction(act);
				} catch (Exception e) {
					Log.getLogger().error(ExceptionUtil.getStackTrace(e));
				}
			}
			suspend(SLEEP_DURATION);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
