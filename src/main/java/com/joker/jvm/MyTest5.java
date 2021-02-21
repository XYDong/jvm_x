package com.joker.jvm;

/**
 * 当一个接口在初始化的时候，并不要求其父接口都完成初始化
 * 只有在真正使用父接口时（如引用接口中所定义的常量时），才会被初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    int a = 5;

}

//class MyChild5 implements MyParent5 {
//    public static int b = 6;
//}
interface MyChild5 extends MyParent5 {
    public static int b = 6;
}

