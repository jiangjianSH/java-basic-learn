package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class URIBuilderDemo {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.jiangjianedu.cn")
                .setPort(80)
                .setPath("/index.html")
                .addParameter("name", "jiangjian")
                .addParameter("keyword", "爱我中华 哈哈哈")
                .build();
        System.out.println(uri.toString());
    }
}
