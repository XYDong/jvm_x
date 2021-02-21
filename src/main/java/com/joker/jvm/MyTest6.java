package com.joker.jvm;

/**
 * 类的初始化的顺序是从上至下，依次执行
 * 首先在类的连接阶段有个赋初值的操作
 * 然后初始化时再赋予正确的值
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println("counter1: " +instance.counter1);
        System.out.println("counter2: " +instance.counter2);
    }
}

class Singleton {

    public static int counter1;


    private Singleton() {
        counter1 ++;
        // 准备阶段的重要意义，如果没有准备阶段的赋予初始值，counter2++ 会报错
        counter2 ++;
    }

    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();


    public static Singleton getInstance() {
        return singleton;
    }

}
