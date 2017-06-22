package com.jiangjian.study.java.advanced.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Demo {
	public static void main(String[] args) {
		String html = "<html><head><title>First parse</title></head>"
				  + "<body><p id='jiangjian' class='yellow' time='13' age='26'>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		Element ele = doc.getElementById("jiangjian");
		System.out.println(ele.attr("age"));
		System.out.println(ele.hasClass("yellow"));
	}
}
