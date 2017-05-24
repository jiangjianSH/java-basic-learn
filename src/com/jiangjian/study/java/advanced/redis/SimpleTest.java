package com.jiangjian.study.java.advanced.redis;


import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/2/7 0007.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("name", "jiangjian");
        System.out.println(jedis.get("name"));
    }
}
