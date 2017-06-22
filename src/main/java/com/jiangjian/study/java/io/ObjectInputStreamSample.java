package com.jiangjian.study.java.io;

import java.io.*;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class ObjectInputStreamSample {
    public static class Person implements Serializable {
        private String name = null;
        private int age = 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.bin"));
        Person person = new Person();
        person.name = "jiangjian";
        person.age = 25;
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bin"));
        Person personRead = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(personRead.name);
        System.out.println(personRead.age);
    }
}
