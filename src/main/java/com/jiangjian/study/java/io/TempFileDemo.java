package com.jiangjian.study.java.io;

import java.io.*;
import java.nio.charset.Charset;

public class TempFileDemo {
    public static void main(String[] args) throws IOException {
        File temp = null;
        BufferedWriter writer = null;
        try {
            temp = File.createTempFile("报税表-", "-南区.txt");
            System.out.println(temp.getAbsolutePath());
            writer =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp), Charset.defaultCharset()));
            writer.write("this is temp text");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (temp != null) {
                temp.delete();
            }
        }
    }
}
