package com.jiangjian.study.java.io;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by Administrator on 2017/1/21 0021.
 */
public class StreamTokenizerSample {
    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader("jiangjian is a good guy."));
        while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(streamTokenizer.sval);
            }
        }
    }
}
