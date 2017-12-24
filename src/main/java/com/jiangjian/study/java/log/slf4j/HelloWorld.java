package com.jiangjian.study.java.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        Marker notifyAdmin = MarkerFactory.getMarker("NOTIFY_ADMIN");

        logger.info(notifyAdmin, "hello world");
    }
}
