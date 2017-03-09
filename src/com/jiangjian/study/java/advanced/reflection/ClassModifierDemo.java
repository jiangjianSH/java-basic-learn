package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

public class ClassModifierDemo {
	public static void main(String[] args) {
		Class cls = ClassModifierDemo.class;
		int modifer = cls.getModifiers();
		if(Modifier.isPublic(modifer)){
			System.out.println("is public");
		}
		if(Modifier.isPrivate(modifer)) {
			System.out.println("is private");
		}
		
		System.out.println(int.class.getName());
		Class stringArrayClass = Array.newInstance(String.class, 0).getClass();
		System.out.println("is array: " + stringArrayClass.isArray());
	}
}
