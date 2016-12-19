package com.yan.po;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {
    private Short empno;

    private String ename;

    private String job;

    private Short mgr;

    private Date hiredate;

    private BigDecimal sal;

    private BigDecimal comm;

    private Short deptno;
    
    private Dept dept;
    
    public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Short getEmpno() {
        return empno;
    }

    public void setEmpno(Short empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Short getMgr() {
        return mgr;
    }

    public void setMgr(Short mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Short getDeptno() {
        return deptno;
    }

    public void setDeptno(Short deptno) {
        this.deptno = deptno;
    }
}