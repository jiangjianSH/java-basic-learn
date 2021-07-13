package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public class Manager extends AuditOperation {
    public Manager(AuditOperation directUpperLeader) {
        super(directUpperLeader);
    }

    @Override
    void audit(int leaveDays) {
        if (leaveDays <= 5) {
            System.out.println(leaveDays + "天需要经理审批的");
            return;
        }
        directUpperLeader.audit(leaveDays);
    }
}
