package com.jiangjian.study.java.io;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        File file = new File(".");

        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        };
        File[] files = file.listFiles(filenameFilter);
        for(File item : files) {
            System.out.println(item);
        }
    }
}
