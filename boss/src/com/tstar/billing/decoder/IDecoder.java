package com.tstar.billing.decoder;

import java.util.List;

import com.tstar.ocs.model.Cdr;

public interface IDecoder {
	// 设置开始解码的字节序号，从0开始编号
	void setStartPos(int pos);
	
	List<Cdr> decode(byte[] content, DecoderConfig config) throws Exception;
	List<Cdr> decode(String filePath, DecoderConfig config) throws Exception;
}
