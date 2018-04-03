package com.jiangjian.study.java.junitapp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDefaultController {
    private DefaultController defaultController;
    private Request request;
    private RequestHandler requestHandler;

    @Before
    public void setUp() {
        defaultController = new DefaultController();
        request = new SampleRequest();
        requestHandler = new SampleHandler();
        defaultController.addHandler(request, requestHandler);
    }

    @Test
    public void testAddHandler() {
        RequestHandler requestHandler1 = defaultController.getHandler(request);
        assertEquals(requestHandler, requestHandler1);
    }


    @Test(expected = RuntimeException.class)
    public void testAddSameHandlerTwice() {
        defaultController.addHandler(request, requestHandler);
    }

    @Test(timeout = 1L)
    public void testTimeLimitOnControlProcessRequest() {
//        try {
//            Thread.sleep(100L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        defaultController.process(request);
    }

    @Test
    @Ignore
    public void testProcessRequest() {
        Response response = defaultController.process(request);
        assertNotNull("response should not be null", response);
        assertEquals("response should be SampleResponse type", response.getClass(), SampleResponse.class);
    }

    private class SampleRequest implements Request {

        @Override
        public String getName() {
            return "Test";
        }
    }

    private class SampleResponse implements Response {

    }

    private class SampleHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }
}
