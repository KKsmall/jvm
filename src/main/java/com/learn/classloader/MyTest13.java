package com.learn.classloader;

public class MyTest13 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (null != classLoader) {
            System.out.println(classLoader = classLoader.getParent());
        }
    }
}
