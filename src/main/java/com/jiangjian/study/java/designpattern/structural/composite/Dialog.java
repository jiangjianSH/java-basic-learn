package com.jiangjian.study.java.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Dialog implements Graphic {
    private List<Graphic> graphicList = new ArrayList<>();

    @Override
    public void print() {
        System.out.println("this is a dialog");
        for(Graphic graphic : graphicList) {
            graphic.print();
        }
    }

    public void addComponent(Graphic graphic) {
        graphicList.add(graphic);
    }
}
