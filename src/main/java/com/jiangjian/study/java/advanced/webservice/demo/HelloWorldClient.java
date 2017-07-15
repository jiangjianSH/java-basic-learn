package com.jiangjian.study.java.advanced.webservice.demo;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Administrator on 2017/5/23.
 */
public class HelloWorldClient {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        URL uri = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://webservice.advanced.java.study.jiangjian.com/", "HelloWorldImplService");
        Service service = Service.create(uri, qname);
        HelloWorld helloWorld = service.getPort(HelloWorld.class);
        System.out.println(helloWorld.getHelloWorldAsString("jiangjian"));
    }
}
