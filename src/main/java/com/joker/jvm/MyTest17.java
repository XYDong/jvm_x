package com.joker.jvm;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("C:\\Users\\shuiq\\Desktop\\");
        Class<?> aClass = loader1.loadClass("com.joker.jvm.MySimple");
        System.out.println("class : " + aClass.hashCode());
//        Object instance = aClass.newInstance();
    }
}
