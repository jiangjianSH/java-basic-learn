package com.jiangjian.study.java.io;

import java.io.File;

public class FileFilterDemo {
    public static void main(String[] args) {
        File currentDir = new File("data.txt");

        File[] fileNames = currentDir.listFiles((file) -> file.getName().endsWith(".txt"));
        for(File fileName : fileNames) {
            System.out.println(fileName);
        }
    }
}
