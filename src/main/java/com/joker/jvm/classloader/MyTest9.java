package com.joker.jvm.classloader;


class MyParent9 {
    public static int a = 3;

    static {
        System.out.println("MyParent9 static block");
    }
}
class MyChild9 extends MyParent9 {
    public static int b = 4;
    static {
        System.out.println("MyChild9 static block");
    }
}
public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }
    public static void main(String[] args) {
        System.out.println(MyChild9.b);
    }
}
