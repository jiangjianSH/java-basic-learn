package com.jiangjian.study.java.generic;

public class GenericMethodSample {

   public static <T> T getValue(T t) {
      System.out.println("Value:" + t);
      return t;
   }

   public static void main(String[] args) {
      String value = GenericMethodSample.getValue("jiangjian");
   }
}
