/**
 * 
 */
package com.tstar.billing.decoder;

/**
 * @author zhumengfeng
 *
 */
public class DecoderConfigLeaf implements IDecoderConfigNode {
	public String tag;
	public String field;
	public Integer size;
	public String dataType;
	public String format;
	public String pattern;
	public Integer patternIndex;
	public String source;
	public String ifexp;
	public String ifval;
}
