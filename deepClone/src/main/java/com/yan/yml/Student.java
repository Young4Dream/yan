package com.yan.yml;

public class Student extends Person {
    private String id;
    private String name;
    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Student(String id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }
}
