package com.tstar.billing.decoder;

import java.util.List;

import com.tstar.ocs.model.Cdr;
import com.tstar.util.StringUtil;

public class AtsFilter implements IFilter {

	public void filt(List<Cdr> cdrs) {
		for (int i = cdrs.size() - 1; i >= 0; i--) {
			Cdr obj = cdrs.get(i);
			// filter null caller or callee
			if (StringUtil.isEmpty(obj.getCaller()) || StringUtil.isEmpty(obj.getCallee())) {
				cdrs.remove(i);
				continue;
			}
			// filter outgoing call
			if (obj.getCallee().length() != 5) {
				cdrs.remove(i);
				continue;
			}
		}
	}

}
