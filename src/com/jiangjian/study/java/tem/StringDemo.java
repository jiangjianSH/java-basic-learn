package com.jiangjian.study.java.tem;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class StringDemo {
    private static String content = "####################http://7xoojv.com1.z0.glb.clouddn.com/FtWEoF7fSNLxsFeEjRdqH9YjMEHZ%%%%%%%%%%%";

    private static String replaceDomain = "http://7xoojv.com1.z0.glb.clouddn.com/";
    private static String newDomain = "http://wwww.acglicensing.com/";
    private static String newPendding = "-951";
    private static int fixedLength = 28;

    public static void main(String[] args) {
        System.out.println(content.indexOf(replaceDomain));
    }
}
