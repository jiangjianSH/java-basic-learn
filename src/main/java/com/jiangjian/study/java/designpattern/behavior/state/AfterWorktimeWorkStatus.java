package com.jiangjian.study.java.designpattern.behavior.state;

public class AfterWorktimeWorkStatus implements WorkStatus {
    @Override
    public void doWork() {
        System.out.println("下班了，回去陪老婆!");
    }

    @Override
    public WorkStatus getPreWorkStatus() {
        return new AfternoonWorkStatus();
    }

    @Override
    public WorkStatus getNextWorkStatus() {
        return new AfterWorktimeWorkStatus();
    }
}
