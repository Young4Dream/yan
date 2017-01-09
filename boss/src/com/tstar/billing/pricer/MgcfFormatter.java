package com.tstar.billing.pricer;

import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

public class MgcfFormatter implements INumberFormatter {

	private String formatCallerNumber(String number) {
		return number;
	}
	
	// MGCF网元均为出局通话，分两种情况：
	// 1. 79字冠补位L1
	private String formatCalleeNumber(String number) {
		if (number.startsWith("79")) {
			return "L1" + number;
		}
		return number;
	}
	
	public void format(CdrLog log, List<Cdr> cdrs) {
		for (Cdr cdr : cdrs) {
			cdr.setCaller(formatCallerNumber(cdr.getCaller()));
			cdr.setCallee(formatCalleeNumber(cdr.getCallee()));
		}
	}

}
