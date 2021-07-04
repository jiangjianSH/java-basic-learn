package com.jiangjian.study.java.designpattern.structural.adaptor;

public class Computer {
    private Charger charger;

    public Computer(Charger charger) {
        this.charger = charger;
    }

    public void doCharge() {
        System.out.println("电脑正在充电，电压为:" + charger.chargeVoltage());
    }

    public static void main(String[] args) {
        Computer computer = new Computer(new ChinaElectricAdapter(new ChinaElectric()));
        computer.doCharge();
    }
}
