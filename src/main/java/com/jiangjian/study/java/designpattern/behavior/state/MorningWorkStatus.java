package com.jiangjian.study.java.designpattern.behavior.state;

public class MorningWorkStatus implements WorkStatus {
    @Override
    public void doWork() {
        System.out.println("现在不工作，学习一些东西");
    }

    @Override
    public WorkStatus getPreWorkStatus() {
        return new MorningWorkStatus();
    }

    @Override
    public WorkStatus getNextWorkStatus() {
        return new NoonWorkStatus();
    }
}
