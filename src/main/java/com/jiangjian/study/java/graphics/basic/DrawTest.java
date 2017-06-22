package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Administrator on 2016/5/15.
 */
public class DrawTest {
   public static void main(String[] args)  {
       EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               JFrame frame = new DrawFrame();
               frame.setTitle("DrawTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           }
       });
   }

}

class DrawFrame extends JFrame {
    public DrawFrame() {
        setSize(600, 600);
        JComponent component = new DrawComponent();
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        add(component);
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //draw a rectangle
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.setPaint(Color.lightGray);
        g2.draw(rect);
        g2.fill(rect);

        //draw the enclosed ellipse
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.setPaint(Color.CYAN);
        g2.draw(ellipse);
        g2.fill(ellipse);

        //draw a diagonal line
        g2.setPaint(Color.RED);
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        //draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.setPaint(Color.orange);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
