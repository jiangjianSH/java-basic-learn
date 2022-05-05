package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public class GroupLeader extends AuditOperation {
    public GroupLeader(AuditOperation directUpperLeader) {
        super(directUpperLeader);
    }

    @Override
    void audit(int leaveDays) {
        if (leaveDays < 3) {
            System.out.println(leaveDays + "天需要组长审批的");
            return;
        }
        directUpperLeader.audit(leaveDays);
    }
}
