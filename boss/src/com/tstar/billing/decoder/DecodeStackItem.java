package com.tstar.billing.decoder;

import java.util.Map;



public class DecodeStackItem {
	TagBean tag;
	Map<String, IDecoderConfigNode> nodes;
	
	public DecodeStackItem(TagBean tag, Map<String, IDecoderConfigNode> nodes) {
		this.tag = tag;
		this.nodes = nodes;
	}
}
