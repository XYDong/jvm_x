package com.joker.jvm.bytecode;

/**
 * 方法的动态分派：
 * 方法动态分派的重要概念：方法接受者（方法由哪个对象调用的）
 *
 * invokevirtual字节码指令的多态查找流程：
 * 1.找到操作数栈顶的第一个元素所指向的对象的实际类型；
 * 2.找到了与常量池中的方法描述符与方法名称相同的方法，并且访问权限校验通过，直接返回实际类型的对象的方法的直接引用
 *
 * 比较方法重载和方法重写，我们可以得到这两个
 * 方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test(){
        System.out.println("fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("Apple");
    }
}
class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("Orange");
    }
}