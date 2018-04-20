package com.jiangjian.study.java.io;

import java.io.File;

public class FilenameFilterDemo {
    public static void main(String[] args) {
        File currentDir = new File(".");
        String[] fileNames = currentDir.list((file, name) -> name.endsWith(".txt"));
        for(String filename : fileNames) {
            System.out.println(filename);
        }
    }
}
