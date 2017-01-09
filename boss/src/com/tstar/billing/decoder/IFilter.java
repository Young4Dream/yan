package com.tstar.billing.decoder;

import java.util.List;

import com.tstar.ocs.model.Cdr;

public interface IFilter {
	void filt(List<Cdr> cdrs);
}
