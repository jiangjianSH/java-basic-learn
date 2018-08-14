package com.jiangjian.study.java.designpattern.structural.composite;

public class Test {
    public static void main(String[] args) {
        Panel panel = new Panel();
        panel.addComponent(new Button("start"));

        Dialog dialog = new Dialog();
        dialog.addComponent(new Button("OK"));
        dialog.addComponent(new Button("Cancel"));

        panel.addComponent(dialog);

        panel.print();


    }
}
