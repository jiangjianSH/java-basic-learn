package com.jiangjian.study.java.exception;

public class FinallyTest {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }catch (RuntimeException e) {
            throw e;
        }finally {
            System.out.println("来我大finally block处理");
        }
    }
}
