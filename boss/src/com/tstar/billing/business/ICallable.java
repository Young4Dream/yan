package com.tstar.billing.business;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ICallable implements Callable<Boolean> {
    private String s;
    private String s1;
    private String s2;

    public ICallable(String s, String s1, String s2) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public Boolean call() throws Exception {
        return this.s.length() + this.s1.length() + this.s2.length() > 50;
    }

    private FutureTask<Boolean> getTask() {
        return new FutureTask<>(this);
    }

    public Thread creatCallableThread() {
        return new Thread(this.getTask());
    }

    public Boolean get() throws Exception {
        return this.getTask().get();
    }

}
