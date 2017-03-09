package com.jiangjian.study.java.advanced.reflection;

import java.io.Serializable;

public class InterfacesInClassDemo implements Serializable {
	public static void main(String[] args) {
		Class[] interfaces = InterfacesInClassDemo.class.getInterfaces();
		System.out.println(interfaces.length);
	}
}
