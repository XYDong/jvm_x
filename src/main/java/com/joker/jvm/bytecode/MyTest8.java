package com.joker.jvm.bytecode;

/**
 * 现代jvm在执行java代码的时候，通常会将解释执行与编译执行二者结合使用。
 * 解释执行：通过解释器读取字节码，遇到相应的指令就去执行该指令；
 * 编译执行：通过即时编译器（Just In Time, JIT）将字节码转换为本地机器码来执行；
 * 现代jvm会根据代码热点来生成相应的本地机器码
 *
 * 基于寄存器的指令集速度优于基于栈的指令集
 * java选择使用基于栈的指令集是为了可移植性
 *
 * 基于栈的指令集所与基于寄存器的指令集之间的关系：
 * 1. jvm执行指令时所采取的的方式基于栈的指令集；
 * 2. 基于栈的指令集主要的操作有入栈和出栈两种；
 * 3. 基于栈的指令集又是在于可移植性，而基于寄存器的指令集是与硬件架构紧密关联的，无法做到可移植；
 * 4. 基于栈的指令集缺点在于完成相同的操作时，指令数量通常要比寄存器的指令集数量多；基于栈的指令集实在内存中完成操作的，
 *    而基于寄存器的指令集是直接有CPU来执行的，它是在高速缓冲区中执行的，速度要快很多。虽然虚拟机可以采用一些优化手段，
 *    但总体来说，基于栈的指令集的执行速度要慢一些。
 *
 */
public class MyTest8 {
    public int myCalculate(){
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b - c) * d;
        return result;
    }

}
