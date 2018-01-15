package com.jiangjian.study.java.advanced.jsoup;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class JueweiDemo {
    private static String url = "https://www.ele.me/shop/553752";

    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient();
        HtmlPage myPage =  webClient.getPage(url);
       // webClient.waitForBackgroundJavaScript(10 * 1000);
        webClient.waitForBackgroundJavaScript(20 * 1000); /* will wait JavaScript to execute up to 30s */
        String pageAsXml = myPage.getTextContent();
        System.out.println(pageAsXml);
//
//        WebResponse response = myPage.getWebResponse();
//        String content = response.getContentAsString();
//        System.out.println(pageAsXml);
//        System.out.println(content);
//        System.out.println(myPage.getBody().getElementsByAttribute("span", "class", "ng-binding").get(0).getTextContent());
   //     Document doc = Jsoup.connect("https://h5.ele.me/shop/#id=653804").get();
//        List<Element> elements = doc.getElementsByClass("shop-header-1SsQo_0");
//        if(!elements.isEmpty()) {
//            Element element = elements.get(0);
//            List<Element> nodes = element.getElementsByClass("shop-header-qCsXg_0");
//            System.out.println(nodes.get(1).outerHtml());
//        }
//        System.out.println();

    }
}
