package com.jiangjian.study.java.advanced.classloader;


import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * thanks to Pankaj, you can follow him on youtube(https://www.youtube.com/user/JournalDev)
 * refer to http://www.journaldev.com/349/java-interview-questions-understanding-and-extending-java-classloader
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    private Class getClass(String name) {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;

        try {
            b = loadClassFileData(file) ;
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading Class : " + name + "'");
        if (name.startsWith("com.jiangjian.study.java")) {
            System.out.println("Loading class using MyLoaderClass");
            return getClass(name);
        }
        return super.loadClass(name);
    }

    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte[] buff = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
}
