package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpEntityDemo {
    public static void main(String[] args) throws IOException {
        StringEntity entity = new StringEntity("important message", ContentType.create("text/plain", "UTF-8"));
        System.out.println(entity.getContentType());
        System.out.println(entity.getContentEncoding());
        System.out.println(entity.getContentLength());
        System.out.println(EntityUtils.toString(entity));
        System.out.println(EntityUtils.toByteArray(entity).length);
    }
}
