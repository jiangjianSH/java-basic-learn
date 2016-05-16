package com.jiangjian.study.java.platformenv.environment;

import java.util.Map;

/**
 * Created by Administrator on 2016/5/15.
 */
public class OperatingSystemEnv {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for(String key : env.keySet()) {
            System.out.println(key + "=" + env.get(key));
        }
    }
}
