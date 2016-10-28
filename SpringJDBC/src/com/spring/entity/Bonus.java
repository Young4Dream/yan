package com.spring.entity;

public class Bonus {
	private String ename;
	private String job;
	private Double sal;
	private Double comm;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Bonus(String ename, String job, Double sal, Double comm) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Bonus [ename=" + ename + ", job=" + job + ", sal=" + sal
				+ ", comm=" + comm + ", getEname()=" + getEname()
				+ ", getJob()=" + getJob() + ", getSal()=" + getSal()
				+ ", getComm()=" + getComm() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
