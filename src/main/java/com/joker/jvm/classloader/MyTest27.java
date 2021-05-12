package com.joker.jvm.classloader;

import java.sql.DriverManager;

public class MyTest27 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestsb","username","pwd");
    }
}
