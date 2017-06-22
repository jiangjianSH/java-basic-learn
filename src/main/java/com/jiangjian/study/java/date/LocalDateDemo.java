package com.jiangjian.study.java.date;

import java.time.LocalDate;

public class LocalDateDemo {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getMonth());
		System.out.println(now.getYear());
		System.out.println("----------------------");
		LocalDate tomorrow = now.plusDays(1L);
		System.out.println(tomorrow.getDayOfMonth());
		System.out.println(tomorrow.getDayOfYear());
		System.out.println(tomorrow.getMonth());
		System.out.println(tomorrow.getYear());
		System.out.println("----------------------");
		
		LocalDate birthday = LocalDate.of(1992, 3, 1);
		System.out.println(birthday.getDayOfMonth());
		System.out.println(birthday.getDayOfYear());
		System.out.println(birthday.getMonth());
		System.out.println(birthday.getYear());
		System.out.println("----------------------");

	}
}