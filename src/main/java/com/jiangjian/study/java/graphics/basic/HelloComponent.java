package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jiangjian on 2017/6/23.
 */
public class HelloComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello, Java!", 125, 95);
    }
}
