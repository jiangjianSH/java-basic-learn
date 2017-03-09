package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodsInClassDemo {
	public static void main(String[] args) {
		Class cls = MethodsInClassDemo.class;
		Method[] methods =cls.getMethods();
		System.out.println("Class Name: " + cls.getName());
		System.out.println("Class Simple Name: " + cls.getSimpleName());
		MethodsInClassDemo instance = new MethodsInClassDemo();
		for(Method method : methods) {
			System.out.println("method:" + method.getName());
			try {
				if(method.getName().startsWith("display")) {
					method.invoke(instance, null);
					System.out.println("----------------------");
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void displayA() {
		System.out.println("A");
	}
	
	public void displayB() {
		System.out.println("B");
	}
}
