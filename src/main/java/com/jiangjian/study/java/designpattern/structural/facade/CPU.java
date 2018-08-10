package com.jiangjian.study.java.designpattern.structural.facade;

public class CPU {
    public void freeze() {
        System.out.println("init cpu");
    }

    public void jump(long position) {
        System.out.println("CPU PC setting on " +position);
    }

    public void execute() {
        System.out.println("executing code from position");
    }
}
