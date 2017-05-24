package com.jiangjian.study.java.advanced.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
public class JacksonSample {
    public static class Car {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) throws IOException {
        Car car = new Car();
        car.setAge(1);
        car.setName("BMW");
    }
}
