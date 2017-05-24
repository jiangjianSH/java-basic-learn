package com.jiangjian.study.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {

	public static void main(String[] args) {
		String patternStr = ".";
		String content = "The quick brown fox jumps over the lazy ox.";

		try {
			Pattern pattern = Pattern.compile(patternStr);
			Matcher m = pattern.matcher(content);
			while (m.find())
				System.out.println(
						"Found [" + m.group() + "] starting at " + m.start() + " and ending at " + (m.end() - 1));
		} catch (PatternSyntaxException pse) {
			System.err.println("Bad regex: " + pse.getMessage());
			System.err.println("Description: " + pse.getDescription());
			System.err.println("Index: " + pse.getIndex());
			System.err.println("Incorrect pattern: " + pse.getPattern());
		}
	}
}
