/**
 * 
 */
package com.tstar.billing.decoder;

import java.util.List;

import com.tstar.ocs.model.Cdr;

/**
 * @author zhumengfeng
 *
 */
public interface ISubDecoder {
	public List<Cdr> decode(String content, DecoderConfigTrunk config, Cdr parent) throws Exception;
}
