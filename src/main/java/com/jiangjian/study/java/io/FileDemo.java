package com.jiangjian.study.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("sss");
        System.out.println("absoulte path:" + file.getAbsolutePath());
        System.out.println("canonical path:" + file.getCanonicalPath());
        System.out.println("parent path: " + file.getParent());
        System.out.println("path: " + file.getPath());
        System.out.println("name: " + file.getName());


        System.out.println("is exist: " + file.exists());
        System.out.println("is file: " + file.isFile());
        System.out.println("is directory: " + file.isDirectory());
        System.out.println("is hidden: " + file.isHidden());
        System.out.println("last modified time: " + new Date(file.lastModified()));
        System.out.println("file length: " + file.length());


        System.out.println("----------------------------------");
        System.out.println("output roots: ");
        File[] roots = File.listRoots();
        for(File root : roots) {
            System.out.println(root);
            System.out.println("Partition: " + root);
            System.out.println("Free space on this partition: " + root.getFreeSpace() / 1024 / 1024 / 1024);
            System.out.println("Usable space on this partition: " + root.getUsableSpace() / 1024 / 1024 / 1024);
            System.out.println("Total space on this partition: " + root.getTotalSpace() / 1024 / 1024 / 1024);
            System.out.println();
        }
    }
}
