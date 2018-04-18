package com.jiangjian.study.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        new File("bwd.txt").delete();
        FileWriter writer = new FileWriter("bwd.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("this is china");
        bw.close();
    }
}
