package com.jiangjian.study.java.template.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FTLHelloWorld {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        try {
            //load template from source folder
            Template template = cfg.getTemplate("src/helloworld.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("message", "Hello World!");

            List<String> countries = new ArrayList<>();
            countries.add("India");
            countries.add("China");
            countries.add("USA");
            countries.add("South Korean");
            countries.add("Japan");
            data.put("countries", countries);

            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
