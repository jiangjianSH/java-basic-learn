package com.jiangjian.study.java.temp;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class 用户 {
    private String 名字;

    public 用户(String 名字) {
        this.名字 = 名字;
    }

    public void 自我介绍() {
        System.out.println("我的名字:" + 名字);
    }

    public static void main(String... args) {
        用户  姜健 = new  用户("姜健");
        姜健.自我介绍();
    }
}
