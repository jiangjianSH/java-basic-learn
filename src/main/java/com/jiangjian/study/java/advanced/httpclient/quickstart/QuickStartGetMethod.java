package com.jiangjian.study.java.advanced.httpclient.quickstart;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class QuickStartGetMethod {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html");
        CloseableHttpResponse response1 = httpClient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            EntityUtils.consume(entity1);
            Reader reader = new BufferedReader(new InputStreamReader(entity1.getContent()));
            int a = reader.read();
            while(a != -1) {
                System.out.print((char)a);
                a = reader.read();
            }
        } finally {
            response1.close();
        }
    }
}
