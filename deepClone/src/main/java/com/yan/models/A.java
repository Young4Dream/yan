package com.yan.models;

import java.util.Date;

public class A {
    private static final long serialVersionUID = 1212L;
    private String value;
    private Integer integer;
    private int anInt;
    private Date date;
    private B b;

    public A(String value, B b) {
        this.value = value;
        this.b = b;
    }

    public A() {
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
