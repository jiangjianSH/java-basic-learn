package com.jiangjian.study.java.io;

import java.io.File;

public class GetUserDirDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
    }
}
