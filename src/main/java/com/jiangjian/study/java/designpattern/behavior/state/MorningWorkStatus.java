package com.jiangjian.study.java.designpattern.behavior.state;

public class MorningWorkStatus implements WorkStatus {
    @Override
    public void doWork(Work work) {
        if(work.getCurrentHour() <= 12) {
            System.out.println("现在不工作，学习一些东西");
        } else {
            work.setWorkStatus(new NoonWorkStatus());
        }
    }

    public static void main(String[] args) {
        String s = "70 72 69 6E 74 6C 6E ";
        System.out.println(new String(hexStringToByteArray(s.replace(" ", ""))));
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
