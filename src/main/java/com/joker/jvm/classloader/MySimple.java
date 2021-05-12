package com.joker.jvm.classloader;

public class MySimple {
    public MySimple() {
        System.out.println("MySimple is loaded by : " + this.getClass().getClassLoader());
        new MyCat();
    }
}
