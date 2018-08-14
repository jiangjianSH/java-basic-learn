package com.jiangjian.study.java.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Panel implements Graphic {
    private List<Graphic> graphicList = new ArrayList<>();

    @Override
    public void print() {
        System.out.println("this is a panel");
        for(Graphic graphic : graphicList) {
            graphic.print();
        }
    }

    public void addComponent(Graphic graphic) {
        graphicList.add(graphic);
    }
}
