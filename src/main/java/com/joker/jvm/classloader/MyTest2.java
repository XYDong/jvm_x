package com.joker.jvm.classloader;


/*
  常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
  本质上，调用类并没有直接引用到定义常量的类，因此并不会出发定义常量的类的初始化

  注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
  以至于删除MyParent2的class的文件都可以
 */
/*
 反编译命令：
 javap -c build/classes/java/main/com/joker/jvm/MyTest2.class
 */

/*
  助记符：
  ldc表示将int，float或是string类型的常量值从常量池汇总推送至栈顶
  bipush表示将单字节（-128 ~ 127）的常量值推送至栈顶
  sipush表示将短整型（-32768 ~ 32767）的常量值推送至栈顶
  iconst_1 表示将int类型1推送至栈顶 （iconst_1 ~ iconst_5)
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.q);
    }
}

class MyParent2 {
    public final static String str = "hello world";
    public final static short s = 128;
    public final static short i = 1;
    public final static short q = 6;

    static {
        System.out.println("MyParent2 static block");
    }
}
