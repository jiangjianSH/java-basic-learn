package com.jiangjian.study.java.graphics.basic;

import java.awt.*;

/**
 * Created by Administrator on 2016/5/15.
 */
public class GraphicsEnvironmentTrial {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for(String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
