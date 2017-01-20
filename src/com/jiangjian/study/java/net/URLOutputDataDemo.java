package com.jiangjian.study.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLOutputDataDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com/url");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        OutputStreamWriter  out = new OutputStreamWriter(urlConnection.getOutputStream());
        out.write("String=abc");
        out.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;
        while((line = in.readLine()) != null) {
            System.out.println(line);
        }

    }
}
