package com.jiangjian.study.java.designpattern.behavior.command;

public class Client {
    public static void main(String[] args) {
        //初始化服务
        Robbert robbert = new Robbert();
        MoveLeftCmd moveLeftCmd = new MoveLeftCmd(robbert);
        MoveRightCmd moveRightCmd = new MoveRightCmd(robbert);

        //命令接收者
        Remoter remoter = new Remoter();

        //设置命令
        remoter.add(moveLeftCmd);
        remoter.add(moveRightCmd);
        remoter.add(moveRightCmd);
        remoter.add(moveLeftCmd);
        remoter.execute();

    }
}
