package com.jiangjian.study.java.advanced.nestedclass;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
public class OuterInnerClass {
    public class InnerClass {
    }

    public static void main(String[] args) {
        OuterInnerClass outerClass =new OuterInnerClass();
        OuterInnerClass.InnerClass innerClass = outerClass.new InnerClass();
    }
}
