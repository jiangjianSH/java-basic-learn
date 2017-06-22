package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/5/15.
 */
public class ImageDisplay {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ImageFrame();
                frame.setTitle("Display Image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }

}

class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 400;

    private Image img;

    public ImageComponent() {
        img = new ImageIcon("mountain.jpg").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(null), img.getHeight(null));

    }
}
