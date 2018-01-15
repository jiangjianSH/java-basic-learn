package com.jiangjian.study.java.designpattern.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class Remoter {
    private List<Command> commandList = new ArrayList<>();

    public void add(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for(Command command : commandList) {
            command.executeCmd();
        }
    }
}
