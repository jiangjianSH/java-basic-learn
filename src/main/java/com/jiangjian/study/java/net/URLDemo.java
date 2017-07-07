package com.jiangjian.study.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL baiduURL = new URL("http://www.baidu.com/article/index.html?name=aa&age=14#main");
        display(baiduURL);

        URL baiduRelURL = new URL(baiduURL, "how-to-learn.html");
        display(baiduRelURL);

        URL qqURL =  new URI("http", "", "www.qq.com", 80, "/ex a/index.html", "name=姜健", "#main").toURL();
        display(qqURL);
    }

    public static void display(URL url) throws IOException {
        System.out.println("\n------------------------------------");
        System.out.println(url.toString());
        System.out.println(url.getAuthority());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

}
