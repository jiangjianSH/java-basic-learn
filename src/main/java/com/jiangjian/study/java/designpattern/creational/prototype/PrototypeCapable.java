package com.jiangjian.study.java.designpattern.creational.prototype;

public interface PrototypeCapable extends Cloneable {
    public PrototypeCapable getClone() throws CloneNotSupportedException;
}
