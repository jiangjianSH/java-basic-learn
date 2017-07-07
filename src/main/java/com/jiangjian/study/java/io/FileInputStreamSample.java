package com.jiangjian.study.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class FileInputStreamSample {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("a.txt");
            int data = inputStream.read();
            while(data != -1) {
                System.out.print((char)data);
                data = inputStream.read();
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
