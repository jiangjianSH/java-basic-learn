package com.jiangjian.study.java.designpattern.behavior.status;

public class AfternoonWorkStatus implements WorkStatus {
    @Override
    public void doWork(Work work) {
        if(work.getCurrentHour() <= 18) {
            System.out.println("我正在疯狂的写代码");
        } else {
            work.setWorkStatus(new AfterWorktimeWorkStatus());
        }
    }
}
