package com.joker.jvm.memory;

/**
 * 演示虚拟机栈溢出
 */
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test(){
        length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Exception e) {
            System.out.println(myTest2.length);
            e.printStackTrace();
        }
    }
}


