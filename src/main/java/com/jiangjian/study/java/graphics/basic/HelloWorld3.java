package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by jiangjian on 2017/6/24.
 */
public class HelloWorld3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world3");
        frame.add(new HelloComponent3("Hello, Java"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);

    }
}

class HelloComponent3 extends JComponent implements MouseMotionListener, ActionListener {
    String theMessage;
    int messageX = 125;
    int messageY = 95;
    JButton button;
    int colorIndex;

    static Color[] someColors = {Color.black, Color.red, Color.green, Color.blue, Color.magenta};

    public HelloComponent3(String theMessage) {
        this.theMessage = theMessage;
        button = new JButton("change the color");
        setLayout(new FlowLayout());
        add(button);
        button.addActionListener(this);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            changeColor();
        }
    }

    private void changeColor() {
        if (++colorIndex == someColors.length)
            colorIndex = 0;
        setForeground( currentColor() ); // Use the new color.
        repaint();
    }

    synchronized private Color currentColor() {
        return someColors[colorIndex];
    }
}
