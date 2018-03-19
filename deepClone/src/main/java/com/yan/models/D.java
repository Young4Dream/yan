package com.yan.models;

import java.util.Date;

public class D {
    private static final long serialVersionUID = 1212L;
    public String value;
    public Integer integer;
    public int anInt;
    public Date date;
    public B b;

    public D(String value, B b) {
        this.value = value;
        this.b = b;
    }

    public D() {
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
