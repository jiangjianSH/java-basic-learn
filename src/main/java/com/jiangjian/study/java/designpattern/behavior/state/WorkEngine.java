package com.jiangjian.study.java.designpattern.behavior.state;

public class WorkEngine {
    private WorkStatus workStatus;

    public WorkEngine() {
        workStatus = new MorningWorkStatus();
    }

    public void next() {
        workStatus = workStatus.getNextWorkStatus();
    }

    public void pre() {
        workStatus = workStatus.getPreWorkStatus();
    }

    public void doWork() {
        workStatus.doWork();
    }

    public static void main(String[] args) {
        WorkEngine work = new WorkEngine();
        work.doWork();

        work.next();
        work.doWork();

        work.next();
        work.doWork();

        work.next();
        work.doWork();

        work.next();
        work.doWork();

        work.pre();
        work.doWork();
    }
}
