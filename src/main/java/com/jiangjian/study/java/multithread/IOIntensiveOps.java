package com.jiangjian.study.java.multithread;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class IOIntensiveOps {
    public static void main(String[] args) throws IOException {
        InputStream is = new URL("https://www.qq.com").openConnection().getInputStream();
        InputStreamReader a = new InputStreamReader(is);
        System.out.println( CharStreams.toString(a));
        is.close();
    }
}
