package com.jiangjian.study.java.designpattern.behavior.mediator;

public class Renter {
    private Long affordRent;

    private Long roomCount;

    private String name;

    public Renter(Long affordRent, Long roomCount, String name) {
        this.affordRent = affordRent;
        this.roomCount = roomCount;
        this.name = name;
    }

    public Long getAffordRent() {
        return affordRent;
    }

    public void setAffordRent(Long affordRent) {
        this.affordRent = affordRent;
    }

    public Long getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Long roomCount) {
        this.roomCount = roomCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "affordRent=" + affordRent +
                ", roomCount=" + roomCount +
                ", name='" + name + '\'' +
                '}';
    }
}
