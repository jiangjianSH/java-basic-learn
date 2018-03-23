package com.jiangjian.study.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CreateOrDeleteDirDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("java.io.tmpdir"));


        File file = new File("file-" + new Random().nextInt(Integer.MAX_VALUE));
        boolean isCreated = file.createNewFile();
        System.out.println("iscreated:" + isCreated);

        System.out.println("can write: " + file.canWrite());
        System.out.println("can read: " + file.canRead());
        System.out.println("can execute: " + file.canExecute());
        boolean isDelete = file.delete();
        System.out.println("isDelete:" + isDelete);

        File temp = File.createTempFile("text", ".txt");

        temp.deleteOnExit();

    }
}
