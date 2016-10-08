package com.jiangjian.study.java.io;

import java.io.File;

/**
 * Created by jiangjian on 16-10-7.
 */
public class ListFiles {
    public static void main(String[] args) {
        File tmp = new File("/tmp");
        for(String file : tmp.list()) {
            System.out.println(file);
        }
    }
}
