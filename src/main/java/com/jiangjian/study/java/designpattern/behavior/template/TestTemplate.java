package com.jiangjian.study.java.designpattern.behavior.template;

import java.io.IOException;

public class TestTemplate {
    public static void main(String[] args) throws IOException {
        AbstractFileProcessor repayFileProcessor = new RepayFileProcessor();
        repayFileProcessor.processFile();
    }
}
