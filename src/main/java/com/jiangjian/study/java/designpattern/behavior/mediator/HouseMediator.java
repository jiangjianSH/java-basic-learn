package com.jiangjian.study.java.designpattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

public class HouseMediator {
    private List<Renter> renters = new ArrayList<>();
    private List<Landlord> landlords = new ArrayList<>();

    public void addRenter(Renter renter) {
        renters.add(renter);
    }

    public void addLandlord(Landlord landlord) {
        landlords.add(landlord);
    }

    public Landlord givePreferLandlord(Renter renter) {
        Landlord preferLandlord = null;
        for(Landlord landlord : landlords) {
            if (landlord.getRent() <= renter.getAffordRent() && landlord.getRoomCount() >= renter.getRoomCount()) {
                if (preferLandlord == null) {
                    preferLandlord = landlord;
                } else {
                    if (preferLandlord.getRent() > landlord.getRent()) {
                        preferLandlord = landlord;
                    }
                }
            }
        }
        return preferLandlord;
    }

    public Renter givePreferRent(Landlord landlord) {
        Renter preferRenter = null;
        for(Renter renter : renters) {
            if (renter.getAffordRent() >= landlord.getRent() && renter.getRoomCount() <= landlord.getRoomCount()) {
                if (preferRenter == null) {
                    preferRenter = renter;
                } else {
                    if (preferRenter.getAffordRent() < renter.getAffordRent()) {
                        preferRenter = renter;
                    }
                }
            }
        }
        return preferRenter;
    }

    public static void main(String[] args) {
        HouseMediator lianjia = new HouseMediator();
        lianjia.addRenter(new Renter(1500L, 1L, "小张"));
        lianjia.addRenter(new Renter(2000L, 2L, "小李"));
        lianjia.addRenter(new Renter(5000L, 2L, "老王"));
        lianjia.addRenter(new Renter(3500L, 1L, "小金"));

        lianjia.addLandlord(new Landlord(5000L, "四平路景秀园501", 2L));
        lianjia.addLandlord(new Landlord(2000L, "四平路宝钢一村303", 1L));
        lianjia.addLandlord(new Landlord(3000L, "四平路宝钢一村101", 2L));
        lianjia.addLandlord(new Landlord(20000L, "四平路世纪花园202", 5L));
        lianjia.addLandlord(new Landlord(1000L, "临平路共康一村301", 2L));

        System.out.println(lianjia.givePreferLandlord(new Renter(2000L, 2L, "小李")));
        System.out.println(lianjia.givePreferRent(new Landlord(3000L, "四平路宝钢一村101", 2L)));
    }
}
