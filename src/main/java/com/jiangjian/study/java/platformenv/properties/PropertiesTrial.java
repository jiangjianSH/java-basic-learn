package com.jiangjian.study.java.platformenv.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/15.
 */
public class PropertiesTrial {
    public static void main(String[] args) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.load(
                new FileInputStream("src/com/jiangjian/study/java/platformenv/properties/default.properties"));
        System.out.println(defaultProperties.getProperty("author"));
        System.out.println(defaultProperties.getProperty("background.color"));

        Properties applicationProperties = new Properties(defaultProperties);
        applicationProperties.load(
                new FileInputStream("src/com/jiangjian/study/java/platformenv/properties/application.properties"));
        System.out.println(applicationProperties.getProperty("author"));
        System.out.println(applicationProperties.getProperty("background.color"));

        Properties runningProperties = new Properties(applicationProperties);
        runningProperties.load(
                new FileInputStream("src/com/jiangjian/study/java/platformenv/properties/lastExecute.properties"));
        System.out.println(runningProperties.getProperty("author"));
        System.out.println(runningProperties.getProperty("background.color"));

        runningProperties.setProperty("background.color", "green");
        runningProperties.store(new FileOutputStream("src/com/jiangjian/study/java/platformenv/properties/lastExecute.properties"), "Nothing");


    }
}
