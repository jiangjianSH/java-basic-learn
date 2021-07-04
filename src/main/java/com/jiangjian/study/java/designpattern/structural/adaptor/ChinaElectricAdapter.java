package com.jiangjian.study.java.designpattern.structural.adaptor;

public class ChinaElectricAdapter implements Charger{
    private ChinaElectric chinaElectric;

    public ChinaElectricAdapter(ChinaElectric chinaElectric) {
        this.chinaElectric = chinaElectric;
    }

    @Override
    public int chargeVoltage() {
        return chinaElectric.outputVoltage() / 10;
    }
}
