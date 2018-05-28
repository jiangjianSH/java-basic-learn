package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.*;
import org.apache.http.message.BasicHttpResponse;

public class HttpMessageHeadersDemo {
    public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
        response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");

        Header firstHeader = response.getFirstHeader("Set-Cookie");
        System.out.println(firstHeader);

        Header lastHeader = response.getLastHeader("Set-Cookie");
        System.out.println(lastHeader);

        //loop header

        HeaderIterator headerIterator = response.headerIterator("Set-Cookie");
        while(headerIterator.hasNext()) {
            Header header = (Header) headerIterator.next();
            System.out.println(header);
        }
    }
}
