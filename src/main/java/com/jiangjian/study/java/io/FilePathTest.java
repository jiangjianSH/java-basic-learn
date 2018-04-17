package com.jiangjian.study.java.io;

import java.io.File;
import java.io.IOException;

public class FilePathTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:/data/db/../a.tmp");
        //getPath会将抽象路径转化为当前运行环境操作系统对应的表达方式
        System.out.println("Path: " + file1.getPath());
        System.out.println("Absolute Path: " + file1.getAbsolutePath());
        System.out.println("Canonical Path: " + file1.getCanonicalPath());
    }
}
