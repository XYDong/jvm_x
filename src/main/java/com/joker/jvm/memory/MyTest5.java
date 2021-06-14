package com.joker.jvm.memory;

/**
 *
 * jps -l 列出所有java 进程
 *
 * jcmd (从JDK1.7 开始启用)
 *
 * 1. jcmd pid VM.flags ： 查看JVM的启动参数
 * 2. jcmd pid help : 列出当前运行的java进程可以执行的操作
 * 3. jcmd pid help JFR.dump : 查看具体命令的选项
 * 4. jcmd pid PerfCounter.print : 查看JVM性能相关的参数
 * 5. jcmd pid VM.uptime: 查看JVM的启动时长
 * 6. jcmd pid GC.class_histogram ： 查看系统中类的统计信息
 * 7. jcmd pid Thread.print : 查看线程的堆栈信息
 * 8. jcmd pid GC.heap_dump filename : 导出Heap dump 文件，导出的文件可以通过jvisualvm 查看
 * 9. jcmd pid VM.system_properties: 查看JVM的属性信息
 * 10.jcmd pid VM.version: 查看目标JVM进程的版本信息
 * 11.jcmd pid VM.command_line: 查看JVM启动的命令行参数
 *
 * jstack : 可以查看或导出Java英语程序中线程的堆栈信息
 *
 * jmc: java Mission Control
 */
public class MyTest5 {
    public static void main(String[] args) {
        while (true){
            System.out.println("hello world");
        }
    }
}
