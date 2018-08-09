package com.jiangjian.study.java.designpattern.structural.proxy;

public class ViewRootUserResource implements SensitiveOp{
    @Override
    public void doOp() {
        System.out.println("list /root dir content");
    }
}
