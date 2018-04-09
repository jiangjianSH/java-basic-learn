package com.jiangjian.study.java.test.htmlunit;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FirstTry {
    @Test
    public void testClassNav() throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage mainPage = webClient.getPage("http://htmlunit.sourceforge.net/apidocs/index.html");
        HtmlPage packagePage = (HtmlPage) mainPage.getFrameByName("packageFrame").getEnclosedPage();
        HtmlPage bVerPage = packagePage.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html").click();
        HtmlParagraph p = (HtmlParagraph) bVerPage.getElementsByTagName("p").item(0);
        Assert.assertTrue("Unexpected text", p.asText().startsWith("Object of this class represent one specific version of a given"));
        webClient.close();
    }
}
