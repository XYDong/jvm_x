package com.joker.jvm;


/**
 * 当前类加载器（current classloader)
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）来加载其他类（指的是所依赖的类）
 * 如果ClassX 引用了 ClassY ，那么ClassX的类加载器就会尝试加载ClassY(前提是ClassY尚未被加载)
 *
 *
 * 线程上下文类加载器（context classloader）
 * 该加载器是从JDK1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
 * 分别用来获取和设置上下文类加载器
 *
 * 如果没有调用setContextClassLoader来设置，线程将集成父线程的上下文类加载器。
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器（AppClassLoader）。在线程中运行的代码可以通过该类加载器来加载类与资源。
 *
 * 线程上下文类加载器的重要性：
 * SPI （service provider interface）
 *
 * 父classloader可以使用当前线程thread.currentThread().getContextClassLoader()所指定的classloader加载的类。
 * 这就改变了双亲委托机制。
 *
 * 线程上下文类加载器就是当前线程的current classloader。
 *
 * 在双亲委托机制下，类加载是由下至上的，即下层的类加载器委托父加载器加载类。但是对于SPI来说，有些接口是Java核心库所提供的，而Java
 * 核心库是由启动类加载器加载的，而这些接口的实现却来自于不同的jar包（厂商提供），Java的启动类加载器是不会加载其他来源的jar包，这样
 * 传统的双亲委托机制就无法满足spi的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现对于接口实现类的加载。
 *
 *
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
