package com.tstar.ac.business;

import java.util.Comparator;

import com.tstar.ac.model.AcCommand;

public class SortCmd implements Comparator {
	
	public int compare(Object o1, Object o2) {
		AcCommand cmd1 = (AcCommand)o1;
		AcCommand cmd2 = (AcCommand)o2;
		if (cmd1.getCmdOrder() == cmd2.getCmdOrder()) {
			return 0;
		} else if (cmd1.getCmdOrder() > cmd2.getCmdOrder()){
			return 1;
		} else {
			return -1;
		}
	}
	
}
