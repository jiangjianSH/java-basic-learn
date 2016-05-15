package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/5/15.
 */
public class SwitchDifferentLookAndFeel {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PlafFrame();
                frame.setTitle("Switch to different lookandfeel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class PlafFrame extends JFrame {
    private JPanel buttonPanel;

    public PlafFrame() {
        buttonPanel = new JPanel();
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 300);
    }
    public void makeButton(String name, final String className) {
        JButton button = new JButton(name);

        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(className);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                    pack();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
