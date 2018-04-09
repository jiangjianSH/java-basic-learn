package com.jiangjian.study.java.test.junitapp;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
