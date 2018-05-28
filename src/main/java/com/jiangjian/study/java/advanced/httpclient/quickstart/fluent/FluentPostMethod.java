package com.jiangjian.study.java.advanced.httpclient.quickstart.fluent;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class FluentPostMethod {
    public static void main(String[] args) throws IOException {
        String content = Request.Post("http://localhost:8080/postData")
                .bodyForm(Form.form().add("name", "vip").add("password", "secret").build()).execute().returnContent().asString();
        System.out.println(content);
    }
}
