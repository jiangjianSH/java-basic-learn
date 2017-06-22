package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/12/11 0011.
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try (OutputStream output = new FileOutputStream("b.txt")) {
            output.write((int)'a');
            output.write((int)'b');
            output.write((int)'c');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
