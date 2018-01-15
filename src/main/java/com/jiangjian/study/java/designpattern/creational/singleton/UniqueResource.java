package com.jiangjian.study.java.designpattern.creational.singleton;

/**
 * Created by Administrator on 2016/12/28 0028.
 */
public class UniqueResource {
    private static UniqueResource uniqueResource = new UniqueResource();

    private UniqueResource() {}

    public static UniqueResource getInstance() {
        return uniqueResource;
    }

    public synchronized void use() {
        System.out.println("使用的是系统唯一的资源");
    }
}

