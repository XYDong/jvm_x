package com.joker.jvm;

/**
 * 在运行期，一个Java类是由该类的完全限定名（binary name ： 二进制名） 和用于加载该类的定义类加载器（defining loader) 所共同决定的。
 * 如果名字相同（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完全相同，并且从详情的位置加载亦是如此。
 */

import sun.misc.Launcher;

/**
 * 在oracle的Hotspot虚拟机中，系统属性sun.boot.class.path如果修改错了，则会出现如下错误：
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("------------------------------");

        /**
         * 内建于jvm中的启动类加载器会加载java.lang.classLoader以及其他的Java平台类，
         * 当JVM启动时，一块特殊的机器码会执行，它会加载扩展类加载器与系统类加载器，这块特殊的机器码就是启动类加载器（bootstrap）
         *
         * 启动类加载器不是Java类，其他加载器都是Java类；
         * 启动类加载器是特定于平台的机器指令，它负责开启整个过程；
         *
         * 启动类加载器还会负责加载供JRE正常运行所需要的的基本组件，包括：java.util与java.lang包中的类等。
         */
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println(Launcher.class.getClassLoader());

        System.out.println("------------------------------");

        System.out.println(System.getProperty("java.system.class.loader"));

        /**
         * java -Djava.system.class.loader=com.joker.jvm.MyTest16 com.joker.jvm.MyTest23  指定自定义的类加载为系统类加载器
         */
        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());



    }
}
