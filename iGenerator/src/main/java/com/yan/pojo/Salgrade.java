package com.yan.pojo;

import java.math.BigDecimal;

public class Salgrade {
    private BigDecimal grade;

    private BigDecimal losal;

    private BigDecimal hisal;

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public BigDecimal getLosal() {
        return losal;
    }

    public void setLosal(BigDecimal losal) {
        this.losal = losal;
    }

    public BigDecimal getHisal() {
        return hisal;
    }

    public void setHisal(BigDecimal hisal) {
        this.hisal = hisal;
    }
}