package com.jiangjian.study.java.designpattern.structural.proxy;

public class Main {
    public static void main(String[] args) {
        SensitiveOp sensitiveOp = new ViewRootUserResource();
        Proxy proxy = new Proxy("root", sensitiveOp);
        proxy.doOp();

        Proxy visitorProxy = new Proxy("visitor", sensitiveOp);
        visitorProxy.doOp();
    }
}
