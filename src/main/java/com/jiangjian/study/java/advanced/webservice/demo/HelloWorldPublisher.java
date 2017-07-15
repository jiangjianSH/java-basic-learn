package com.jiangjian.study.java.advanced.webservice.demo;

import javax.xml.ws.Endpoint;

/**
 * Created by Administrator on 2017/5/23.
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}
