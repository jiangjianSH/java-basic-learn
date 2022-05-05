package com.jiangjian.study.java.designpattern.behavior.state;

public class NoonWorkStatus implements WorkStatus {
    @Override
    public void doWork() {
        System.out.println("中午我要休息，不写代码");
    }

    @Override
    public WorkStatus getPreWorkStatus() {
        return new MorningWorkStatus();
    }

    @Override
    public WorkStatus getNextWorkStatus() {
        return new AfternoonWorkStatus();
    }
}
