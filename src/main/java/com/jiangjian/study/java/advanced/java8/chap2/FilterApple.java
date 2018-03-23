package com.jiangjian.study.java.advanced.java8.chap2;

import com.jiangjian.study.java.advanced.java8.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilterApple {
    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 100), new Apple("blue", 40));
        System.out.println(filterApple(apples, (Apple apple) -> apple.getColor().equals("red")).size());
        Comparator<Apple> comparable = (Apple a1, Apple a2) -> a1.getWeight();
    }
}
