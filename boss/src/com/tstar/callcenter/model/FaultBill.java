package com.tstar.callcenter.model;

import java.util.Date;

public class FaultBill {
    private int nid;
    private String vcagentno;
    private String vctel;
    private Date dtregtime;
    private String vcfaulttype;
    private String vcfaultphenomenon;
    private String vccontacts;
    private String vcmemo1;
    private String vcmemo2;
    private String vcmemo3;
    private String vcmemo4;
    private String vcmemo5;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getVcagentno() {
		return vcagentno;
	}
	public void setVcagentno(String vcagentno) {
		this.vcagentno = vcagentno;
	}
	public String getVctel() {
		return vctel;
	}
	public void setVctel(String vctel) {
		this.vctel = vctel;
	}
	public String getVcfaulttype() {
		return vcfaulttype;
	}
	public void setVcfaulttype(String vcfaulttype) {
		this.vcfaulttype = vcfaulttype;
	}
	public String getVcfaultphenomenon() {
		return vcfaultphenomenon;
	}
	public void setVcfaultphenomenon(String vcfaultphenomenon) {
		this.vcfaultphenomenon = vcfaultphenomenon;
	}
	public String getVccontacts() {
		return vccontacts;
	}
	public void setVccontacts(String vccontacts) {
		this.vccontacts = vccontacts;
	}
	public String getVcmemo1() {
		return vcmemo1;
	}
	public void setVcmemo1(String vcmemo1) {
		this.vcmemo1 = vcmemo1;
	}
	public String getVcmemo2() {
		return vcmemo2;
	}
	public void setVcmemo2(String vcmemo2) {
		this.vcmemo2 = vcmemo2;
	}
	public String getVcmemo3() {
		return vcmemo3;
	}
	public void setVcmemo3(String vcmemo3) {
		this.vcmemo3 = vcmemo3;
	}
	public String getVcmemo4() {
		return vcmemo4;
	}
	public void setVcmemo4(String vcmemo4) {
		this.vcmemo4 = vcmemo4;
	}
	public String getVcmemo5() {
		return vcmemo5;
	}
	public void setVcmemo5(String vcmemo5) {
		this.vcmemo5 = vcmemo5;
	}
	public Date getDtregtime() {
		return dtregtime;
	}
	public void setDtregtime(Date dtregtime) {
		this.dtregtime = dtregtime;
	}
}
