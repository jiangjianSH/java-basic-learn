package com.jiangjian.study.java.advanced.java8.chap3;

/**
 * @author jiangjian
 */
public class UseLambdas {
    public void doOps(FC1 fc1) {

    }

//
//    public void doOps(FC2 fc2) {
//
//    }

    public static void main(String[] args) {
        new UseLambdas().doOps((int x, int y) -> x -y);
    }
}
