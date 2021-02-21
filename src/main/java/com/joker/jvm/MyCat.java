package com.joker.jvm;

public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());
    }
}
