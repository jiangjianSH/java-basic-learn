package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtocolInterceptorDemo {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
            AtomicInteger count = (AtomicInteger) context.getAttribute("count");
            request.addHeader("Count", Integer.toString(count.incrementAndGet()));
        }).build();

        AtomicInteger count = new AtomicInteger(1);
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAttribute("count", count);
        HttpPost post = new HttpPost("http://localhost:8080/postData");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        post.setEntity(new UrlEncodedFormEntity(nvps));
        for(int i = 0; i < 10; i++) {
            CloseableHttpResponse response = httpClient.execute(post, localContext);
            response.close();
        }
    }
}
