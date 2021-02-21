package com.joker.jvm;


/*
 对于静态字段来说，自有直接定义了该字段的类才会被初始化
 当类在初始化时，要求其父类全部初始化完成

 -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来
 jvm参数说明：
 -XX:+<option> , 表示开启option选项
 -XX:-<option> , 表示关闭option选项
 -XX:<option>=<value> , 表示将option选项的值设置为value
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.str2);
    }
}

class MyParent1{
    public static String str = "Hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{
    public static String str2 = "Hello world";

    static {
        System.out.println("mychild  block");
    }
}
