package com.jiangjian.study.java.advanced.mybatis;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

public class LogFactoryDemo {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(LogFactoryDemo.class);
        log.debug("test");
    }
}
