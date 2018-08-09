package com.jiangjian.study.java.designpattern.behavior.status;

public class MorningWorkStatus implements WorkStatus {
    @Override
    public void doWork(Work work) {
        if(work.getCurrentHour() <= 12) {
            System.out.println("现在不工作，学习一些东西");
        } else {
            work.setWorkStatus(new NoonWorkStatus());
        }
    }
}
