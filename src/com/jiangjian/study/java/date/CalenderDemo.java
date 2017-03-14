package com.jiangjian.study.java.date;

import java.util.Calendar;

public class CalenderDemo {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.ZONE_OFFSET)/1000/3600);
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		cal.roll(Calendar.HOUR_OF_DAY, 22);
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}
}
