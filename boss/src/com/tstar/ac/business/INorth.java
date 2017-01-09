/**
 * 北向接口
 */
package com.tstar.ac.business;

/**
 * @author zhumengfeng
 *
 */
public interface INorth {
	void open(String url) throws Exception;
	void close() throws Exception;
	boolean connected();
	RetMsg execute(String cmd) throws Exception;
	RetMsg execute(String cmd, String prompt) throws Exception;
}
