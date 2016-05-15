package com.jiangjian.study.java.graphics.basic;

import javax.swing.*;

/**
 * Created by Administrator on 2016/5/15.
 */
public class LookAndFeelsTrial {
    public static void main(String[] args) {
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos) {
            System.out.println(info.getName());
            System.out.println(info.getClassName());
            System.out.println();
        }
    }
}
