package com.jiangjian.study.java.designpattern.structural.composite;

public class Button implements Graphic {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void print() {
        System.out.println("this is a " + label + " button");
    }
}
