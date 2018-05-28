package com.jiangjian.study.java.advanced.httpclient;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

public class HeaderElementDemo {
    public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
        response.addHeader("Set-Cookie", "c2=b;path=\"/\",c3=c;domain=\"localhost\"");

        HeaderElementIterator headerElementIterator = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
        while(headerElementIterator.hasNext()) {
            HeaderElement element = headerElementIterator.nextElement();
            System.out.println("Name: " + element.getName());
            System.out.println("Value: " + element.getValue());
            System.out.println("________________________________________");

            NameValuePair[] parameters = element.getParameters();
            for(NameValuePair parameter : parameters) {
                System.out.println(parameter.getName() + ":" + parameter.getValue());
            }
        }

    }
}
