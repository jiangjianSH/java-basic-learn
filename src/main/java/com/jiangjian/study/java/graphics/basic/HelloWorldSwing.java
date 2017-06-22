package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/5/14.
 */
public class HelloWorldSwing {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hello World Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NotHelloWorldComponent component = new NotHelloWorldComponent();
        frame.add(component);
        frame.pack();

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
