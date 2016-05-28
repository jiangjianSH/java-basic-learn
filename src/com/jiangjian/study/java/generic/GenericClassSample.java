package com.jiangjian.study.java.generic;

public class GenericClassSample {
    public static void main(String[] args) {
        // Pair<String, int> pair = new Pair<>();
        // 上面被注释的代码会提示语法错误，Java类型参数不允许是基本数据类型
        //具体原因可以参考:http://stackoverflow.com/questions/2721546/why-dont-java-generics-support-primitive-types

        Pair<String, Integer> orderList = new Pair<>();

        orderList.setFirst("面包");
        orderList.setSecond(5);

        System.out.println("购买：" + orderList.getFirst());
        System.out.println("数量: " + orderList.getSecond());
    }
}
