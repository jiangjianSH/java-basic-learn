package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class FileReaderSample {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("a.txt.bak");
            int data = fileReader.read();
            while(data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
