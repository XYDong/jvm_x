package com.joker.jvm.classloader;

/**
 * 类加载
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());
        Class<?> cClass = Class.forName("com.joker.jvm.classloader.C");
        System.out.println(cClass.getClassLoader());

    }
}

class C {

}
