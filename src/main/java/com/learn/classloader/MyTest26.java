package com.learn.classloader;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 线程上下文类加载器的一般使用模式：获取-使用-还原
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try {
 *     Thread.currentThread().setContextClassLoader(target);
 *     myMethod();
 * } finally {
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载或实例化低层的类时，就必须通过线程上下文类加载器来帮主高层的ClassLoader
 * 找到并加载该类
 */
public class MyTest26 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:");
    }
}
