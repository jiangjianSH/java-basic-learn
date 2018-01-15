package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;

/**
 * Created by jiangjian on 2017/6/23.
 */
public class Hello {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 600);
        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.add(new HelloComponent());
        jFrame.setVisible(true);
    }
}
