package com.jiangjian.study.java.designpattern.behavior.chainofresponsibility;

public class AuditProcess {
    private AuditOperation auditOperation;

    public AuditProcess() {
        auditOperation = new GroupLeader(new Manager(new CEO(new Boss(null))));
    }

    public void auditLeaveDays(int days) {
        auditOperation.audit(days);
    }

    public static void main(String[] args) {
        AuditProcess auditProcess = new AuditProcess();
        auditProcess.auditLeaveDays(1);
        auditProcess.auditLeaveDays(9);
    }
}
