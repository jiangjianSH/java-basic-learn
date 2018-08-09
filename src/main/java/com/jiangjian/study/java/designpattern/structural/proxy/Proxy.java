package com.jiangjian.study.java.designpattern.structural.proxy;

public class Proxy implements SensitiveOp {
    String user;
    SensitiveOp sensitiveOp;

    public Proxy(String user, SensitiveOp sensitiveOp) {
        this.user = user;
        this.sensitiveOp = sensitiveOp;
    }

    @Override
    public void doOp() {
        if("root".equals(user)) {
            sensitiveOp.doOp();
        } else {
            System.err.println("no permission");
        }
    }
}
