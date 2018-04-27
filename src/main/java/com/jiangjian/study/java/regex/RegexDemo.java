package com.jiangjian.study.java.regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input regular express:");
		String regularExpr = sc.nextLine();
		System.out.print("input string to be matched:");
		String inputStr = sc.nextLine();
		try {
			Pattern pattern = Pattern.compile(regularExpr);
			Matcher m = pattern.matcher(inputStr);
			boolean found = false;
			while (m.find()) {
				System.out.println(
						"Found [" + m.group() + "] starting at " + m.start() + " and ending at " + (m.end()));
				found = true;
			}
			if(!found) {
				System.out.println("Not Found");
			}
		} catch (PatternSyntaxException pse) {
			System.err.println("Bad regex: " + pse.getMessage());
			System.err.println("Description: " + pse.getDescription());
			System.err.println("Index: " + pse.getIndex());
			System.err.println("Incorrect pattern: " + pse.getPattern());
		}
	}
}
