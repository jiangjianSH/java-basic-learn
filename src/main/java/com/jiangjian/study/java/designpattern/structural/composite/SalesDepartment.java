package com.jiangjian.study.java.designpattern.structural.composite;

public class SalesDepartment implements Department {

    private Integer id;
    private String name;

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    public SalesDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}