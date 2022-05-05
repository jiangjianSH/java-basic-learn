package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.Array;

public class PackageDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(Array.newInstance(String.class, new int[]{2, 3, 2, 4, 5, 6, 2}).getClass());
		Array.newInstance(String[].class, 5);

//		Class.forName(char.class.getName());
//		Package p = PackageDemo.class.getPackage();
//		System.out.println("Name: " + p.getName());
//		System.out.println("ImplementationTitle: " + p.getImplementationTitle());
//		System.out.println("ImplementationVersion: " + p.getImplementationVersion());
//		System.out.println("ImplementationVendor: " + p.getImplementationVendor());
	}
}
