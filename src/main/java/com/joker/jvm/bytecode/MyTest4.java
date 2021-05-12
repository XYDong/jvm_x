package com.joker.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 字节码分析异常处理的过程
 * 字节码中的test方法中，分析出来 参数为1，改参数为this,java编译器编译时，会将this作为参数传递进去，但是只有非静态方法才行
 */
public class MyTest4 {

    public void test() {
        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
