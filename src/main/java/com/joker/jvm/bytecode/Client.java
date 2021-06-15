package com.joker.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler ds = new DynamicSubject(realSubject);
        Class<?> cls = realSubject.getClass();

//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),ds);
        subject.request();
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
