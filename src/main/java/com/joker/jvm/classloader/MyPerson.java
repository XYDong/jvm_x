package com.joker.jvm.classloader;

public class MyPerson {
    private MyPerson myPerson;

    public void setPerson(Object object) {
        this.myPerson = (MyPerson) object;
    }
}
