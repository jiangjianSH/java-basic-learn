package com.jiangjian.study.java.graphics.basic;

import java.awt.*;

/**
 * Created by Administrator on 2016/5/14.
 */
public class DetectScreenSize {
    public static void main(String[] args) {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        System.out.println(toolKit.getScreenSize());
    }
}
