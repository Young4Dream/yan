package com.yan.models;

import java.io.Serializable;
import java.util.List;

public class B {
    private static final long serialVersionUID = 1222L;
    private String value;
    private List<C> c;

    public B() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public B(String value, List<C> c) {
        this.value = value;
        this.c = c;
    }

    public List<C> getC() {
        return c;
    }

    public void setC(List<C> c) {
        this.c = c;
    }
}
