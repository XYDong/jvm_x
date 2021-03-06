package com.joker.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.joker.jvm.classloader.CL");
        System.out.println(aClass);
        System.out.println("==================");
        Class<?> aClass1 = Class.forName("com.joker.jvm.classloader.CL");
        System.out.println(aClass1);
    }
}
