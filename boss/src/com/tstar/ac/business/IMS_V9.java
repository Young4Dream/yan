/**
 * 
 */
package com.tstar.ac.business;

import com.tstar.ac.util.SoapUI;
import com.tstar.util.RegExp;

/**
 * @author zhumengfeng
 *
 */
public class IMS_V9 implements INorth {

	// CC08命令返回值的正则表达式
	private static final String codePattern = "ResultCode>(\\d+)<";
	private static final String descPattern = "ResultDesc>(.*)<";
	private static final String faultCodePattern = "faultcode>(\\d+)<";
	private static final String faultDescPattern = "faultstring>(\\d+)<";
	private static final String UNKNOWN_ERR = "999999";
	
	private SoapUI soap = null;
	
	public void open(String url) throws Exception {
		if (soap == null) {
			soap = new SoapUI(url);
		}
		soap.connect();
	}

	public void close() throws Exception {
		soap.disconnect();
		soap = null;
	}

	public boolean connected() {
		return (soap == null ? false : soap.getConnected());
	}

	public RetMsg execute(String cmd) throws Exception {
		String result = soap.execute(cmd).trim();
		// 去掉回车、换行、TAB键
		String tmp = result.replaceAll("[\\t\\n\\r]", "");
		// 获取返回代码
		String[] values = RegExp.getValues(codePattern, tmp);
		// 获取返回描述
		String[] descValues = RegExp.getValues(descPattern, tmp);
		if (values != null && values.length > 0) {
			return new RetMsg(values[0], descValues[0]);
		} else {
			String[] faultValues = RegExp.getValues(faultCodePattern, tmp);
			String[] faultDescValues = RegExp.getValues(faultDescPattern, tmp);
			if (faultValues != null && faultValues.length > 0) {
				return new RetMsg(faultValues[0], faultDescValues[0]);
			} else {
				return new RetMsg(UNKNOWN_ERR, result);
			}
		}
	}

	public RetMsg execute(String cmd, String prompt) throws Exception {
		return execute(cmd);
	}

}
