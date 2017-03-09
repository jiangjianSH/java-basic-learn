package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstrucotrsInClassDemo {
	public static void main(String[] args) {
		Constructor[] cs = ConstrucotrsInClassDemo.class.getConstructors();
		System.out.println(cs.length);
		try {
			ConstrucotrsInClassDemo demo = (ConstrucotrsInClassDemo) cs[0].newInstance(null);
			demo.displayA();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void displayA() {
		System.out.println("A");
	}
}
