package com.jiangjian.study.java.designpattern.creational.prototype;

public abstract class Prototype implements Cloneable {
    protected  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype clone() throws CloneNotSupportedException{
        return (Prototype) super.clone();
    }
}