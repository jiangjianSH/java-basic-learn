package com.jiangjian.study.java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("pom.xml");
        BufferedReader br = new BufferedReader(reader, 1024*16);

        String content = br.readLine();
        while(content != null) {
            System.out.println(content);
            content = br.readLine();
        }

        br.close();

    }
}
