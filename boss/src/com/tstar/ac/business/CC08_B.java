/**
 * 
 */
package com.tstar.ac.business;

import com.tstar.ac.util.SocketClient;
import com.tstar.util.RegExp;

/**
 * @author zhumengfeng
 *
 */
public class CC08_B implements INorth {

	// CC08命令返回值的正则表达式
	private static final String pattern = "RETCODE = (\\d+) ";
	private static final String UNKNOWN_ERR = "999999";
	
	private SocketClient socket = null;
	
	public void open(String url) throws Exception {
		if (socket == null) {
			String[] infos = url.split(":");
			socket = new SocketClient(infos[0], Integer.parseInt(infos[1]));
		}
		socket.connect();
	}

	public void close() throws Exception {
		socket.disconnect();
		socket = null;
	}

	public boolean connected() {
		return socket == null ? false : socket.getConnected();
	}

	public RetMsg execute(String cmd) throws Exception {
		String result = socket.execute(cmd).trim();
		// 去掉TAB、回车、换行
		String tmp = result.replaceAll("[\\t\\n\\r]", "");
		String[] values = RegExp.getValues(pattern, tmp);
		if (values != null && values.length > 0) {
			return new RetMsg(values[0], result);
		} else {
			return new RetMsg(UNKNOWN_ERR, result);
		}
	}

	public RetMsg execute(String cmd, String prompt) throws Exception {
		return execute(cmd);
	}

}
