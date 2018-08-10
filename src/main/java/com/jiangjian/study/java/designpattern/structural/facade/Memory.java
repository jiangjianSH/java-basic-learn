package com.jiangjian.study.java.designpattern.structural.facade;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("read data from disk");
    }
}
