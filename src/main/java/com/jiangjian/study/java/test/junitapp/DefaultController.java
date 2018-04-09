package com.jiangjian.study.java.test.junitapp;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {
    private Map requestHandlers = new HashMap<>();

    protected RequestHandler getHandler(Request request) {
        if(!this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("can not found handler for request:" + request.getName());
        }
        return (RequestHandler) this.requestHandlers.get(request.getName());
    }
    @Override
    public Response process(Request request) {
        RequestHandler requestHandler = getHandler(request);
        try {
            return requestHandler.process(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse(request, e);
        }
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if(this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has registerd:" + request.getName());
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
