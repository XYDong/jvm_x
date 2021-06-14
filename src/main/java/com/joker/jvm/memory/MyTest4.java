package com.joker.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区内存溢出错误
 */
public class MyTest4 {
    public static void main(String[] args) {
        for ( ; ; ){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback( (MethodInterceptor)(obj, method, arg1, proxy) ->
                    proxy.invoke(obj,arg1));
            System.out.println("Hello world");
            enhancer.create();
        }
    }
}
