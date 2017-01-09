package com.tstar.billing.pricer;

import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

public class AtsFormatter implements INumberFormatter {

	// ATS网元均为内部通话，直接去掉字冠(8620)即可
	private String formatNumber(String number) {
		if (number == null || "".equals(number)) return number;
		if (number.startsWith(INumberFormatter.IMS_LOCAL_PREFIX)) {
			return number.substring(INumberFormatter.IMS_LOCAL_PREFIX.length());
		}
		return number;
	}
	
	public void format(CdrLog log, List<Cdr> cdrs) {
		for (Cdr cdr : cdrs) {
			cdr.setCaller(formatNumber(cdr.getCaller()));
			cdr.setCallee(formatNumber(cdr.getCallee()));
		}
	}

}
