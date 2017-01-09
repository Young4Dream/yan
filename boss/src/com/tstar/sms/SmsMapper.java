/**
 * 
 */
package com.tstar.sms;

import java.util.Map;

/**
 * @author zhumengfeng
 *
 */
public interface SmsMapper {
	void send(Map<String, Object> map);
}
