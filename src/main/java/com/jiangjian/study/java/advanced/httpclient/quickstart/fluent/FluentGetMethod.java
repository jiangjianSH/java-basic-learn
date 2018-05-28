package com.jiangjian.study.java.advanced.httpclient.quickstart.fluent;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class FluentGetMethod {
    public static void main(String[] args) throws IOException {
        String content = Request.Get("https://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html")
                .execute().returnContent().asString();
        System.out.println(content);
    }
}
