package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Administrator on 2016/5/15.
 */
public class FontTest{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FontFrame fontFrame = new FontFrame();
                fontFrame.setTitle("Font Test");
                fontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fontFrame.setVisible(true);
            }
        });
    }
}

class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Hello, World";

        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D  bounds = f.getStringBounds(message, context);


        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        double ascent = -bounds.getY();
        double baseY = y + ascent;

        g2.drawString(message, (int)x, (int)baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        Rectangle2D rectangle2D = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rectangle2D);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}
