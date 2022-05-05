package com.jiangjian.study.java.designpattern.behavior.template;

import java.io.IOException;
import java.io.InputStream;

abstract public class AbstractFileProcessor {
    private InputStream inputStream;

    private InputStream decryptContentStream;

    public abstract InputStream getFileInputStream();

    public abstract InputStream decryptContent(InputStream inputStream) throws IOException;

    public abstract void reconcile(InputStream inputStream);

    public void clean() {
        try {
            decryptContentStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processFile() throws IOException {
        inputStream = getFileInputStream();
        decryptContentStream = decryptContent(inputStream);
        reconcile(decryptContentStream);
        clean();
    }
}
