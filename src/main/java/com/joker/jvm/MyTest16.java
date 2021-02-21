package com.joker.jvm;

import java.io.*;

/**
 * 类加载器
 */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();// 将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示的指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }
    public MyTest16(ClassLoader parent) {
        super(parent); // 显示的指定该类加载器的父加载器
    }


    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest16 == [ " +this.classLoaderName+" ]" ;
    }

    @Override
    protected Class<?> findClass(String calssName) {
        System.out.println("findclass invoked : " + calssName);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = this.loaderClassData(calssName);
        return this.defineClass(calssName,data,0 , data.length);
    }

    private byte[] loaderClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream bos = null;
        className = className.replace(".","\\");
        try {
//            this.classLoaderName = this.classLoaderName.replace(".","/");
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            bos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                bos.write(ch);
            }
            data = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("E:\\IDEA_workspace\\DEMO\\jvm-1\\build\\classes\\java\\main\\com\\joker\\jvm");
        loader1.setPath("C:\\Users\\shuiq\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.joker.jvm.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object instance = clazz.newInstance();
        System.out.println(instance);

        System.out.println();
        loader1 = null;
        clazz = null;
        instance = null;
        System.gc();
        Thread.sleep(20000);

//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setPath("C:\\Users\\shuiq\\Desktop\\");
//        Class<?> clazz2 = loader2.loadClass("com.joker.jvm.MyTest1");
//        System.out.println("class: " + clazz2.hashCode());
//        Object instance2 = clazz2.newInstance();
//        System.out.println(instance2);
//
//        System.out.println();
//
//        MyTest16 loader3 = new MyTest16("loader3");
//        loader3.setPath("C:\\Users\\shuiq\\Desktop\\");
//        Class<?> clazz3 = loader3.loadClass("com.joker.jvm.MyTest1");
//        System.out.println("class: " + clazz3.hashCode());
//        Object instance3 = clazz3.newInstance();
//        System.out.println(instance3);

        loader1 = new MyTest16("loader1");

        loader1.setPath("C:\\Users\\shuiq\\Desktop\\");
        clazz = loader1.loadClass("com.joker.jvm.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        instance = clazz.newInstance();
        System.out.println(instance);


    }
}
