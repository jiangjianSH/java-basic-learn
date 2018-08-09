package com.jiangjian.study.java.advanced.jvm.basic.classloader.dynamicextension;

public class Greet {
    public static void main(String[] args) {
        if(args.length <= 1) {
            System.out.println("Enter base path and greeter class names as args");
            return;
        }

        GreeterClassLoader greeterClassLoader = new GreeterClassLoader(args[0]);
    }
}
