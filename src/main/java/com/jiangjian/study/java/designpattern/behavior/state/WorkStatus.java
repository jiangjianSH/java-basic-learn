package com.jiangjian.study.java.designpattern.behavior.state;

public interface WorkStatus {
    void doWork();

    WorkStatus getPreWorkStatus();

    WorkStatus getNextWorkStatus();
}
