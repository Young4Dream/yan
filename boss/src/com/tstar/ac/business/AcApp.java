/**
 * 自控主程序
 */
package com.tstar.ac.business;

import java.nio.charset.Charset;

import com.tstar.util.Log;

/**
 * @author zhumengfeng
 *
 */
public class AcApp {
	
	public static void main(String[] args) {
		//Log.getLogger().info("testing cbms...");
		//Log.getLogger().info("user.count=" + BroadBus.getUserCount());
		
		Log.getLogger().info("Auto control progress started.");
		
		String currCharset = Charset.defaultCharset().toString();
		Log.getLogger().info("Default Charset: " + Charset.defaultCharset());
		Log.getLogger().info("file.encoding: " + System.getProperty("file.encoding"));
		if (!currCharset.equals("GBK")) {
			Log.getLogger().warn("Please adjust charset and file encoding to GBK");
		}
		
		// 生成指令线程
		Thread thAct = new ActThread();
		thAct.setName("Action Daemon");
		thAct.start();
		
		// 执行指令线程
		Thread thExeCmd = new CmdThread();
		thExeCmd.setName("Cmd Daomen");
		thExeCmd.start();
	}
	
}
