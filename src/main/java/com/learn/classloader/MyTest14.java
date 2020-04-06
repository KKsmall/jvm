package com.learn.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * classloader还可以用来获取资源路径
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        //获取当前线程上下文的ClassLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String resourceName = "com/learn/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }
    }
}
