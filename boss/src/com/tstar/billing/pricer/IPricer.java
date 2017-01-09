package com.tstar.billing.pricer;

import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.ocs.model.CdrLog;

public interface IPricer {
	void format(CdrLog log, List<Cdr> cdrs);
	void pricing(CdrLog log, List<Cdr> cdrs);
}
