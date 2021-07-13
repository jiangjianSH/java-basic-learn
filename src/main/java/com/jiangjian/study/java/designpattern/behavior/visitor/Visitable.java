package com.jiangjian.study.java.designpattern.behavior.visitor;


public interface Visitable {
    double accept(Visitor visitor);
}
