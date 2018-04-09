package com.jiangjian.study.java.test.junitapp.stubs;

import org.apache.http.HttpHeaders;
import org.junit.*;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestWebClientSkeleton {
    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8080);
        Context root = new Context(server, "/testGetContentOk");
        TestWebClientSkeleton webClientSkeleton = new TestWebClientSkeleton();
        Handler handler = webClientSkeleton.new TestGetContentOkHandler();
        root.setHandler(handler);
        server.start();
    }

    @AfterClass
    public static void tearDown() {

    }


    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentOk"));
        assertEquals("It works", result);
    }

    private class TestGetContentOkHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            OutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }
}
