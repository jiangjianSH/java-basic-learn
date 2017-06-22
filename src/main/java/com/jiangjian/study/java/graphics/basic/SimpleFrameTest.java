package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/5/14.
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFALUT_HEIGHT = 300;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFALUT_HEIGHT);
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}
