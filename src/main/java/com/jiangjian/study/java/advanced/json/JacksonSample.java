package com.jiangjian.study.java.advanced.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

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
      List<Car> cars = null;
    }

    private Car getDefaultCar() {
        Car car = new Car();
        car.setAge(11);
        car.setName("BMT");
        return car;
    }
}
