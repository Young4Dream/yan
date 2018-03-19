package com.yan.models;

import java.io.Serializable;

public class C {

    private static final long serialVersionUID = 12221L;
    private String value;

    public C(String value) {
        this.value = value;
    }

    public C() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
