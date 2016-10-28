package com.spring.entity;

public class Salgrade {
	private int grade;
	private double losal;
	private double hisal;
	public int getGrade() {
		return grade;
	}
	public Salgrade(int grade, double losal, double hisal) {
		super();
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}
	@Override
	public String toString() {
		return "Salgrade [grade=" + grade + ", losal=" + losal + ", hisal="
				+ hisal + ", getGrade()=" + getGrade() + ", getLosal()="
				+ getLosal() + ", getHisal()=" + getHisal() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public double getLosal() {
		return losal;
	}
	public void setLosal(double losal) {
		this.losal = losal;
	}
	public double getHisal() {
		return hisal;
	}
	public void setHisal(double hisal) {
		this.hisal = hisal;
	}
}
