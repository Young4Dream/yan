/**
 * 
 */
package com.tstar.billing.decoder;

import java.util.Map;

/**
 * @author zhumengfeng
 *
 */
public class DecoderConfigTrunk implements IDecoderConfigNode {
	public String tag;
	public String field;
	public Integer size;
	public String action;
	public String className;
	public String business;
	public Map<String, IDecoderConfigNode> nodes;
}
