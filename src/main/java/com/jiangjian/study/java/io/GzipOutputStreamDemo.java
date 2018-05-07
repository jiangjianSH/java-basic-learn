package com.jiangjian.study.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class GzipOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream("22.gz"));
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("I love programming.");
        printWriter.close();
    }
}
