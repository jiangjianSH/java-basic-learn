package com.jiangjian.study.java.designpattern.creational.prototype;

public class User extends Prototype {
    public User(String username) {
        this.name = username;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("jiangjain");
        System.out.println(user.getName());

        User cloneUser = (User) user.clone();
        System.out.println(cloneUser.getName());
    }
}
