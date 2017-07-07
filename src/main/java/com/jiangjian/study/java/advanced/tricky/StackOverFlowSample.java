package com.jiangjian.study.java.advanced.tricky;

public class StackOverFlowSample {
    StackOverFlowSample() {
        System.out.println("Hello");
    }

    StackOverFlowSample sample = new StackOverFlowSample();

    public static void main(String[] args) {
        StackOverFlowSample test = new StackOverFlowSample();
    }
}
