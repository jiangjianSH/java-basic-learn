package com.jiangjian.study.java.designpattern.behavior.command;

public class MoveLeftCmd implements Command {
    private Robbert robbert;

    public MoveLeftCmd(Robbert robbert) {
        this.robbert = robbert;
    }

    @Override
    public void executeCmd() {
        robbert.moveLeft();
    }
}
