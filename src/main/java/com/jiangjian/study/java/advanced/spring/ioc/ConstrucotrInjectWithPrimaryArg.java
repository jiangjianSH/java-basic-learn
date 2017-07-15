package com.jiangjian.study.java.advanced.spring.ioc;

import java.beans.ConstructorProperties;

/**
 * Created by Administrator on 2017/7/10.
 */
public class ConstrucotrInjectWithPrimaryArg {
    private int age;
    private String name;

    @ConstructorProperties({"age", "name"})
    public ConstrucotrInjectWithPrimaryArg(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ConstrucotrInjectWithPrimaryArg{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
