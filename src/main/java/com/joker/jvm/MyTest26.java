package com.joker.jvm;

/**
 * 线程上下文类加载器的一般使用模式（获取 - 使用- 还原）
 * ClassLoader cla = Thread.currentThread.getContextClassLoader();
 * try{
 *     Thread.currentThread.setContextClassLoader(targetTcal);
 *     myMethod();
 * } final {
 *     Thread.currentThread().getContextClassLoader(cla);
 * }
 *
 * myMethod里边则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。
 *
 * 如果个类有类加载器A加载，那么这个类所依赖的类也是有A加载器加载（如果该类没有被加载过）
 * contextClassLoader 的作用就是为了破坏Java的委托加载机制。
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或者实例化）低层的类时，就必须要通过线程上下文类加载器来帮助
 * 高层ClassLoader找到并加载该类。
 *
 */
public class MyTest26 {

    public static void main(String[] args) {

    }
}
