package com.jiangjian.study.java.test.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BrowserCompatibilityTest {
    private BrowserVersion browserVersion;

    @Parameterized.Parameters
    public static Collection<BrowserVersion> getBrowserVersions() {
        return Arrays.asList(new BrowserVersion[]{BrowserVersion.FIREFOX_52,
                BrowserVersion.INTERNET_EXPLORER,
                BrowserVersion.CHROME,
                BrowserVersion.EDGE});
    }

    public BrowserCompatibilityTest(BrowserVersion browserVersion) {
        this.browserVersion = browserVersion;
    }

    @Test
    public void testSearchPage() {
        WebClient webClient = new WebClient(browserVersion);
        System.out.println(browserVersion);
        webClient.close();
    }
}
