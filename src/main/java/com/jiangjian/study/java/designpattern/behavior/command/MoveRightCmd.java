package com.jiangjian.study.java.designpattern.behavior.command;

public class MoveRightCmd implements Command {
    private Robbert robbert;

    public MoveRightCmd(Robbert robbert) {
        this.robbert = robbert;
    }

    @Override
    public void executeCmd() {
        robbert.moveRight();
    }
}
