package com.tstar.billing.biller;

import java.util.List;

import com.tstar.ocs.model.Cdr;

public interface IBiller {
	void billing(List<Cdr> cdrs);
}
