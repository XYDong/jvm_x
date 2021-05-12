package com.joker.jvm.classloader;

/**
 * java -Djava.ext.dirs=./ com.joker.jvm.classloader.MyTest22  手动加载类
 * jar cvf test.jar com/joker/jvm/MyTest1.class 将class文件打成jar的压缩包
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
