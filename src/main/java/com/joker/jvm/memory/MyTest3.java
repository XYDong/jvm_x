package com.joker.jvm.memory;

/**
 * 死锁分析 jvisualvm 和 jconsole
 */
public class MyTest3 {
    public static void main(String[] args) {
        new Thread( () -> A.method(),"ThreadA").start();
        new Thread( () -> B.method(),"ThreadB").start();

        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

class A {
    public static synchronized void method(){
        System.out.println("method from A");
        try {
            Thread.sleep(2000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method(){
        System.out.println("method from B");
        try {
            Thread.sleep(2000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
