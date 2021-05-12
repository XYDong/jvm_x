package com.joker.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 类加载器的双亲委托机制的好处：
 * 1. 可以确保Java核心库的类型安全：所有Java应用至少都会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个
 * 类会被加载到Java虚拟机中；如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的
 * java.lang.Object类，而且这些类之间不兼容，相互不可见（命名空间的作用）。借助于双亲委托机制，Java核心类库中的类的
 * 加载工作都是由启动类加载器来统一完成，从而确保了Java应用所使用的都是一个版本的Java核心类库，他们之间是相互兼容的。
 * 2. 可以确保Java核心类库所提供的类不会被自定义的类所替代。
 * 3. 不同的类加载器可以为相同名称（binary name）的类所创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要不同的类
 * 加载器来加载它们即可。不同的类加载所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个又一个相互隔离的Java类空间，
 * 这类技术在很多框架汇总都得到了实际应用。
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> aClass1 = loader1.loadClass("com.joker.jvm.classloader.MyPerson");
        Class<?> aClass2 = loader2.loadClass("com.joker.jvm.classloader.MyPerson");

        System.out.println(aClass1 == aClass2);

        Object obj1 = aClass1.newInstance();
        Object obj2 = aClass2.newInstance();

        Method method = aClass1.getMethod("setPerson",Object.class);
        method.invoke(obj1,obj2);

    }
}
