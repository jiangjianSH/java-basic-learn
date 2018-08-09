package com.jiangjian.study.java.designpattern.behavior.status;

public class NoonWorkStatus implements WorkStatus {
    @Override
    public void doWork(Work work) {
        if(work.getCurrentHour() <= 14) {
            System.out.println("中午我要休息，不写代码");
        } else {
            work.setWorkStatus(new AfternoonWorkStatus());
        }
    }
}
