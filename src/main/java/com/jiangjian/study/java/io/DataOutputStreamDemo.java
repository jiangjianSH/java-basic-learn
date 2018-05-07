package com.jiangjian.study.java.io;

import java.io.*;

public class DataOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("dos.txt"));
        out.writeChar('是');
        out.flush();
        out.close();
    }
}
