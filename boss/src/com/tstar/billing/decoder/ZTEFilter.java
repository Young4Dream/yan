package com.tstar.billing.decoder;

import java.util.List;

import com.tstar.ocs.model.Cdr;

public class ZTEFilter implements IFilter {

	@Override
	public void filt(List<Cdr> cdrs) {
		for (int i = 0; i < cdrs.size(); i++) {
			Cdr cdr = new Cdr();
			cdr = cdrs.get(i);
			String caller = cdr.getCaller();
			String prefix = caller.substring(0, 3);
			// 前缀是393的应去除
			if (prefix.equals("393")) {
				String nomarlCaller = caller.substring(3);
				cdr.setCaller(nomarlCaller);
			}
			if(caller.equals("0031322 32310030303 30303 33")){
				cdrs.remove(i);
			}
		}
	}

}
