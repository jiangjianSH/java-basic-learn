package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public abstract class AuditOperation {
    protected AuditOperation directUpperLeader;

    public AuditOperation(AuditOperation directUpperLeader) {
        this.directUpperLeader = directUpperLeader;
    }

    abstract void audit(int leaveDays);
}
