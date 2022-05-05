package com.jiangjian.study.java.designpattern.behavior.state;

public class AfternoonWorkStatus implements WorkStatus {
    @Override
    public void doWork() {
        System.out.println("我正在疯狂的写代码");
    }

    @Override
    public WorkStatus getPreWorkStatus() {
        return new NoonWorkStatus();
    }

    @Override
    public WorkStatus getNextWorkStatus() {
        return new AfterWorktimeWorkStatus();
    }
}
