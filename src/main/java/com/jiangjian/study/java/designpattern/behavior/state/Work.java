package com.jiangjian.study.java.designpattern.behavior.state;

public class Work {
    private int currentHour = 9;

    private WorkStatus workStatus;

    public Work() {
        workStatus = new MorningWorkStatus();
    }

    public int getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(int currentHour) {
        this.currentHour = currentHour;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public void doWork() {
        workStatus.doWork(this);
    }

    public static void main(String[] args) {
        Work work = new Work();
        work.doWork();

        work.setCurrentHour(13);
        work.doWork();

        work.setCurrentHour(15);
        work.doWork();

        work.setCurrentHour(17);
        work.doWork();

        work.setCurrentHour(19);
        work.doWork();

        work.setCurrentHour(20);
        work.doWork();

        work.setCurrentHour(23);
        work.doWork();
    }
}
