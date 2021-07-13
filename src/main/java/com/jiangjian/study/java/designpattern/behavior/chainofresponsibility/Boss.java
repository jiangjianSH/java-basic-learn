package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public class Boss extends AuditOperation{
    public Boss(AuditOperation directUpperLeader) {
        super(directUpperLeader);
    }

    @Override
    void audit(int leaveDays) {
        System.out.println(leaveDays + "天需要老板审批");
    }
}
