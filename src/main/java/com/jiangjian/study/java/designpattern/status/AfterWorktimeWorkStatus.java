package com.jiangjian.study.java.designpattern.status;

public class AfterWorktimeWorkStatus implements WorkStatus {
    @Override
    public void doWork(Work work) {
        if(work.getCurrentHour() >= 18) {
            System.out.println("下班了，回去陪老婆!");
        }
    }
}
