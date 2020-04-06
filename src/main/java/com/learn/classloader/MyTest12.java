package com.learn.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}

/**
 * 打印结果
 * class com.learn.classloader.CL
 * -------------
 * Class CL
 * class com.learn.classloader.CL
 * 结论：调用ClassLoader类的loadClass()方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 * Class.forName是反射，属于主动使用的7中方式之一
 */

public class MyTest12 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.learn.classloader.CL");
        System.out.println(clazz);
        System.out.println("-------------");
        clazz = Class.forName("com.learn.classloader.CL");
        System.out.println(clazz);

    }
}
