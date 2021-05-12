package com.joker.jvm.bytecode;

/**
 * 栈帧（stack frame）
 * 栈帧是一种用于帮助虚拟机执行方法带哦用与方法执行的数据结构
 * 栈帧本事是一种数据结构，封装了方法的局部表量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 *
 * 符号引用 直接引用
 * 有些符号引用是在类加载阶段伙食第一次使用时就会转换为直接引用，这种转换叫做静态解析；另一些符号
 * 引用则是在每次运行期转换为直接引用，这种转换叫做动态链接，这种体现为Java的多态性。
 */

/**
 * java的方法调用的字节码指令的5种情况：
 * 1. invokeinterface:调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的哪个对象的特定方法。
 * 2. invokestatic：调用静态方法。
 * 3. invokespecial：调用自己的私有方法、构造方法以及父类的方法。
 * 4. invokevirtual：调用虚方法，运行期动态查找的过程。
 * 5. invokedynamic：动态调用方法。
 */

/**
 * 静态解析的四种情形：
 * 1. 静态方法
 * 2. 父类方法
 * 3. 构造方法
 * 4. 私有方法
 *
 */
public class MyTest {
    public static void test(){
        System.out.println("test invoke");
    }

    public static void main(String[] args) {
        test();
    }
}
