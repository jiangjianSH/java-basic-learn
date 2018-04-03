package com.jiangjian.study.java.junitapp;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
