package com.jiangjian.study.java.test.junitapp.stubs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class StubHttpURLConnection extends HttpURLConnection {
    private boolean isInput = true;
    /**
     * Constructor for the HttpURLConnection.
     *
     * @param u the URL
     */
    protected StubHttpURLConnection(URL u) {
        super(u);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if(!isInput) {
            throw new ProtocolException("cannot read from urlConnection" + "if doInput = false(call setDoInput(true)");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(new String("It works").getBytes());
        return bais;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
