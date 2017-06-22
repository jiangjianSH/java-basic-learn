package com.jiangjian.study.java.advanced.reflection;

import java.lang.reflect.Field;

public class FieldsInClassDemo {
	public static int VERSION = 2;
	private String name;
	
	public FieldsInClassDemo(String name) {
		this.name = name;
	}
	
	/**
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = FieldsInClassDemo.class.getDeclaredFields();
		FieldsInClassDemo instance = new FieldsInClassDemo("shanghai");
		for(Field field : fields) {
			System.out.println("filed name :" + field.getName());
			System.out.println("filed value :" + field.get(instance));
		}
		
		try {
			Field staticField = FieldsInClassDemo.class.getField("VERSION");
			System.out.println(staticField.getName());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
