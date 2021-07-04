package com.jiangjian.study.java.designpattern.creational.prototype;

public class ComplexComponent implements PrototypeCapable{
    private int score;

    public ComplexComponent(String seed, int randomNum) {
        this.score = (int) (seed.length() * randomNum * (Math.pow(2, randomNum)));
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public PrototypeCapable getClone() throws CloneNotSupportedException {
        return (PrototypeCapable) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ComplexComponent c1 = new ComplexComponent("demostring", 200);
        System.out.println(c1.getScore());

        ComplexComponent c2 = (ComplexComponent) c1.getClone();
        System.out.println(c2.getScore());

    }
}
