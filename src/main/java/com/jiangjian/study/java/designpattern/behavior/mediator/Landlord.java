package com.jiangjian.study.java.designpattern.behavior.mediator;

public class Landlord {
    /**
     * 租金
     */
    private Long rent;

    private String address;

    private Long roomCount;

    public Landlord(Long rent, String address, Long roomCount) {
        this.rent = rent;
        this.address = address;
        this.roomCount = roomCount;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Long roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "rent=" + rent +
                ", address='" + address + '\'' +
                ", roomCount=" + roomCount +
                '}';
    }
}
