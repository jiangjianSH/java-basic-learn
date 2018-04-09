package com.jiangjian.study.java.test.junitapp;

public interface Controller {
    Response process(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}
