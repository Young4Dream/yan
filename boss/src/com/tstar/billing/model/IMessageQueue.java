/**
 * 
 */
package com.tstar.billing.model;

import java.io.Serializable;

/**
 * @author zhumengfeng
 *
 */
public interface IMessageQueue {
	public void connect();
	public void disconnect();
	public void send(Serializable obj) throws Exception;
	public Serializable receive() throws Exception;
}
