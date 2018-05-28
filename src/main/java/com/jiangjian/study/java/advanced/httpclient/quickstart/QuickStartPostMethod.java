package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class QuickStartPostMethod {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8080/postData");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        post.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpClient.execute(post);
        System.out.println(response.getStatusLine());

        HttpEntity responseHttpEntity = response.getEntity();
        System.out.println("Content Type:" + responseHttpEntity.getContentType());
        System.out.println("Content Encoding" + responseHttpEntity.getContentEncoding());
        System.out.println("Content Length: " + responseHttpEntity.getContentLength());

        System.out.println("___________________________________________");

        dumpHeaders(response.getAllHeaders());

        System.out.println("___________________________________________");

        Reader reader = new BufferedReader(new InputStreamReader(responseHttpEntity.getContent()));
        int a = reader.read();
        while(a != -1) {
            System.out.print((char)a);
            a = reader.read();
        }
        response.close();
    }

    public static void dumpHeaders(Header[]  headers) {
        for(Header header : headers) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
    }
}
