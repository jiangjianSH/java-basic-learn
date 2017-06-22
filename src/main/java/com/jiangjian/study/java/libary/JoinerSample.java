package com.jiangjian.study.java.libary;


import com.google.common.base.Joiner;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class JoinerSample {
    public static void main(String[] args) {
        System.out.println(Joiner.on("?").skipNulls().join("http://test.shiyouxinxi.com/study/topic/detail/1", "type=1&id=32"));
        Long num = 89402L;
        System.out.println(Math.round(num/3600));
    }
}
