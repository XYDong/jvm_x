package com.joker.jvm.bytecode;

public class MyTest2 implements MyTest3 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str) {
            System.out.println("hello word");
        }
    }

    private synchronized static void test2() {

    }

    @Override
    public void printStr(String str) {
        System.out.println(str);
    }
}
