package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public class CEO extends AuditOperation{
    public CEO(AuditOperation directUpperLeader) {
        super(directUpperLeader);
    }

    @Override
    void audit(int leaveDays) {
        if (leaveDays <= 10) {
            System.out.println(leaveDays + "天需要CEO审批");
            return;
        }
        directUpperLeader.audit(leaveDays);
    }
}
