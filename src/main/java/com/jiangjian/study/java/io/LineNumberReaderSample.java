package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
public class LineNumberReaderSample {
    public static void main(String[] args) {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("a.txt.bak"));
            int data = lineNumberReader.read();
            while(data != -1) {
                System.out.println(lineNumberReader.getLineNumber() + ":" + (char)data);
                data = lineNumberReader.read();
            }
            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
