/**
 * 
 */
package com.tstar.billing.decoder;

import java.util.ArrayList;
import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.BeanHelper;

/**
 * @author zhumengfeng
 *
 */
public class FlatTextDecoder implements ISubDecoder {

	public List<Cdr> decode(String content, DecoderConfigTrunk config,
			Cdr parent) throws Exception {
		List<Cdr> cdrs = new ArrayList<Cdr>();
		Cdr obj = new Cdr(parent);
		BeanHelper.setPropertyFromStr(obj, config.field, content);
		//obj.business = config.business;
		cdrs.add(obj);
		return cdrs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
