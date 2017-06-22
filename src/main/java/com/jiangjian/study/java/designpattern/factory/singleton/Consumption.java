package com.jiangjian.study.java.designpattern.factory.singleton;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
public class Consumption {
    public static void main(String[] args) {
        UniqueResource uniqueResource = UniqueResource.getInstance();
        uniqueResource.use();
    }
}
