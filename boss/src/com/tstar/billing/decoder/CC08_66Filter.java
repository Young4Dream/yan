package com.tstar.billing.decoder;
/**
 * 17.01.09
 * @author yan
 */
import java.util.List;

import com.tstar.ocs.model.Cdr;

public class CC08_66Filter implements IFilter{

	@Override
	public void filt(List<Cdr> cdrs) {
		// TODO Auto-generated method stub
		for(int i=0;i<cdrs.size();i++){
			Cdr cdr = new Cdr();
			cdr=cdrs.get(i);
			//去除被叫为0054452 0083331100000000的异常话单
			String callee = cdr.getCallee();
			if(callee.equals("0054452 0083331100000000")){
				cdrs.remove(i);
			}
		}
	}

}
