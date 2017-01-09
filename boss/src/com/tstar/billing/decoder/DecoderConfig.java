/**
 * 
 */
package com.tstar.billing.decoder;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhumengfeng
 *
 */
public class DecoderConfig {
	public String name;
	public String className;
	public String tag;
	public Integer size;
	public Integer fieldCount;
	public String category;
	public String pricer;
	public String formatter;
	public String filter;
	public Integer headerSize;
	//public Map<String, IDecoderConfigNode> nodes;
	public ConcurrentHashMap<String, IDecoderConfigNode> nodes;
}
