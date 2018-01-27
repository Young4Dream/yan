package com.yan.model;

public class Project {
    private String name;
    private String path;
    private Integer jvmXms;
    private Integer jvmXmx;

    public Project(String name) {
        this.name = name;
    }

    public Integer getJvmXms() {

        return jvmXms;
    }

    public void setJvmXms(Integer jvmXms) {
        this.jvmXms = jvmXms;
    }

    public Integer getJvmXmx() {
        return jvmXmx;
    }

    public void setJvmXmx(Integer jvmXmx) {
        this.jvmXmx = jvmXmx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
