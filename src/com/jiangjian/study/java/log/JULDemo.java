package com.jiangjian.study.java.log;

import java.util.logging.Handler;
import java.util.logging.Logger;


public class JULDemo {
	private static Logger logger = Logger.getLogger(JULDemo.class.getName());
	public static void main(String[] args) {
		logger.severe("this is java util log");
		Handler[] handlers = logger.getHandlers();
		System.out.println(handlers.length);
	}
}
