package com.tstar.billing.pricer;

import java.util.List;

import com.tstar.billing.business.ProfileBus;
import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

public interface INumberFormatter {
	public static final String IMS_NATIONAL_PREFIX = ProfileBus.getNationalPrefix();
	public static final String IMS_LOCAL_PREFIX = ProfileBus.getLocalPrefix();
	
	void format(CdrLog log, List<Cdr> cdrs);
}
