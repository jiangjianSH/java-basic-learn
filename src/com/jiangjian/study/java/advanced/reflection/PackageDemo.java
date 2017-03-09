package com.jiangjian.study.java.advanced.reflection;

public class PackageDemo {
	public static void main(String[] args) {
		Package p = PackageDemo.class.getPackage();
		System.out.println("Name: " + p.getName());
		System.out.println("ImplementationTitle: " + p.getImplementationTitle());
		System.out.println("ImplementationVersion: " + p.getImplementationVersion());
		System.out.println("ImplementationVendor: " + p.getImplementationVendor());
	}
}
