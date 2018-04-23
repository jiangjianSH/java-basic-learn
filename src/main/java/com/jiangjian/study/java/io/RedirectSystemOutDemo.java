package com.jiangjian.study.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectSystemOutDemo {
    public static void main(String[] args) throws FileNotFoundException {
        new File("redirect.out").delete();

        PrintStream os = new PrintStream(new FileOutputStream("redirect.out"));
        System.setOut(os);
        System.out.println("爱我中华");
        os.close();
    }
}
