package com.jiangjian.study.java.io;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/11 0011.
 */
public class SystemDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("this is a normal message.");
        System.in.read();
        System.err.println("this is an error message.");
    }
}
