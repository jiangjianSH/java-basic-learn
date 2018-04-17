package com.jiangjian.study.java.io;

import java.io.File;

public class FilePermissionDemo {
    public static void main(String[] args) {
        File file = new File("icon.gif");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
    }
}
