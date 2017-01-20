package com.jiangjian.study.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class FileSample {
    public static void main(String[] args) {
        File file = new File("a.txt.bak");
        System.out.println("is direcotory:" + file.isDirectory());
        System.out.println("file exist:" + file.exists());
        System.out.println("File length:" + file.length());
   //     file.renameTo(new File("a.txt.bak"));
    }
}
