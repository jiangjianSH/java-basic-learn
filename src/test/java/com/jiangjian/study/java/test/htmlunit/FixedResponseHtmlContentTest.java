package com.jiangjian.study.java.test.htmlunit;

import com.gargoylesoftware.htmlunit.MockWebConnection;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FixedResponseHtmlContentTest {
    @Test
    public void testDefaultResponse() throws IOException {
        String expectedHtmlContent = "<html><head><title>hi</title></head><body>welcome</body></html>";

        MockWebConnection webConnection = new MockWebConnection();
        webConnection.setDefaultResponse(expectedHtmlContent);

        WebClient webClient = new WebClient();
        webClient.setWebConnection(webConnection);

        HtmlPage page = webClient.getPage("http://page");
        assertEquals("title not match", "hi", page.getTitleText());

        webClient.close();
    }

    @Test
    public void testMultiPageDefaultResponse() throws IOException {
        String expectedHtmlContent4Page1 = "<html><head><title>hi page 1</title></head><body>welcome</body></html>";

        String expectedHtmlContent4Page2 = "<html><head><title>hi page 2</title></head><body>welcome</body></html>";

        String expectedHtmlContent4Page3 = "<html><head><title>hi page 3</title></head><body>welcome</body></html>";

        MockWebConnection webConnection = new MockWebConnection();
        webConnection.setResponse(new URL("http://s1/page1"), expectedHtmlContent4Page1);
        webConnection.setResponse(new URL("http://s1/page2"), expectedHtmlContent4Page2);
        webConnection.setResponse(new URL("http://s1/page3"), expectedHtmlContent4Page3);

        WebClient webClient = new WebClient();
        webClient.setWebConnection(webConnection);

        HtmlPage page1 = webClient.getPage("http://s1/page1");
        assertEquals("page 1 title not match", "hi page 1", page1.getTitleText());

        HtmlPage page2 = webClient.getPage("http://s1/page2");
        assertEquals("page 2 title not match", "hi page 2", page2.getTitleText());

        HtmlPage page3 = webClient.getPage("http://s1/page3");
        assertEquals("page 3 title not match", "hi page 3", page3.getTitleText());
        webClient.close();
    }

}
