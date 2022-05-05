package com.jiangjian.study.java.designpattern.structural.decorator;

public class RawCake implements Cake {

    @Override
    public void desc() {
        System.out.println("包含：普通蛋糕面包");
    }
}
