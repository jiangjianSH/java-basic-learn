package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/5/15.
 */
public class NotHelloWorldComponent extends JComponent {
    @Override
    public void paint(Graphics g) {
        g.drawString("Not a Hello, World program", 75, 100);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}
