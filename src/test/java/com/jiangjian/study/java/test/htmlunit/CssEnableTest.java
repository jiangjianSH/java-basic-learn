package com.jiangjian.study.java.test.htmlunit;

import com.gargoylesoftware.htmlunit.DefaultCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;

public class CssEnableTest {
    @Test
    public void enableCssTest() throws IOException {
        WebClient webClient = new WebClient();
        webClient.setCssErrorHandler(new DefaultCssErrorHandler());
        HtmlPage page = webClient.getPage("https://www.baidu.com");
        System.out.println(page.getBody().getTextContent());
        webClient.close();
    }
}
