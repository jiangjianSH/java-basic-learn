package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by jiangjian on 2017/6/24.
 */
public class HelloWorld2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world2");
        frame.add(new HelloComponent2("Hello, Java"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);

    }
}

class HelloComponent2 extends JComponent implements MouseMotionListener {
    String theMessage;
    int messageX = 125;
    int messageY = 95;

    public HelloComponent2(String theMessage) {
        this.theMessage = theMessage;
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawString(theMessage, messageX, messageY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse moved");
    }
}
