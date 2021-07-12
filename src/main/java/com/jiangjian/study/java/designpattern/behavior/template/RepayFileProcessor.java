package com.jiangjian.study.java.designpattern.behavior.template;

import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RepayFileProcessor extends AbstractFileProcessor{
    @Override
    public InputStream getFileInputStream() {
        return new ByteArrayInputStream("**test**".getBytes());
    }

    @Override
    public InputStream decryptContent(InputStream inputStream) throws IOException {
        ByteSource byteSource = new ByteSource() {
            @Override
            public InputStream openStream() throws IOException {
                return inputStream;
            }
        };
        String text = byteSource.asCharSource(Charsets.UTF_8).read();
        return new ByteArrayInputStream(text.replace("*", "").getBytes());
    }

    @Override
    public void reconcile(InputStream inputStream) {
        try {
            System.out.println(IOUtils.toString(inputStream, StandardCharsets.UTF_8.name()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
