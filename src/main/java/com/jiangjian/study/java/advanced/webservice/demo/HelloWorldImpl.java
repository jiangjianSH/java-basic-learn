package com.jiangjian.study.java.advanced.webservice.demo;

import javax.jws.WebService;

/**
 * Created by Administrator on 2017/5/23.
 */
@WebService(endpointInterface = "com.jiangjian.study.java.advanced.webservice.demo.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
    @Override
    public String getHelloWorldAsString(String name) {
        System.out.println("get executing");
        return "Hello World JAX-WS " + name;
    }
}
