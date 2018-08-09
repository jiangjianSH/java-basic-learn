package com.jiangjian.study.java.advanced.jvm.basic.classloader.dynamicextension;

import java.io.*;
import java.util.Hashtable;

public class GreeterClassLoader extends ClassLoader {
    private Hashtable types = new Hashtable();
    private String basePath;

    public GreeterClassLoader(String arg) {
        basePath = arg;
    }

    public synchronized Class loadClass(String className,
                                        boolean resolveIt) throws ClassNotFoundException {
        Class result;
        byte classData[];
        // Check the local cache
        result = (Class) types.get(className);
        if (result != null) {
            // Return a cached class
            return result;
        }
        // Check with the primordial class loader
        try {
            result = super.findSystemClass(className);
            // Return a system class
            return result;
        } catch (ClassNotFoundException e) {
        }
        // Don't attempt to load a system file except through
        // the primordial class loader
        if (className.startsWith("java.")) {
            throw new ClassNotFoundException();
        }
        // Try to load it from the basePath directory.
        classData = getTypeFromBasePath(className);
        if (classData == null) {
            System.out.println("GCL - Can't load class: "
                    + className);
            throw new ClassNotFoundException();
        }
        // Parse it
        result = defineClass(className, classData, 0,
                classData.length);
        if (result == null) {
            System.out.println("GCL - Class format error: "
                    + className);
            throw new ClassFormatError();
        }
        if (resolveIt) {
            resolveClass(result);
        }
        // Add newly loaded type to private name cache
        types.put(className, result);
        // Return class from basePath directory
        return result;
    }

    private byte[] getTypeFromBasePath(String className) {
        InputStream in = null;
        String fileName = basePath + "/" + className + ".class";
        try {
            in = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            int c = in.read();
            while (c != -1) {
                out.write(c);
                c = in.read();
            }
        } catch (IOException e) {
            System.out.println("GCL: Error reading bytes of:" + className);
            e.printStackTrace();
            return null;
        }
        return out.toByteArray();
    }
}
