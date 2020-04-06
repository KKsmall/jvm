package com.learn.classloader;

import java.lang.reflect.Method;

public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.learn.classloader.MyPerson");
        Class<?> clazz2 = loader1.loadClass("com.learn.classloader.MyPerson");

        //true因为，虽然是示例了两个类加载器，但是都是委托的父加载器，而父加载器能找到 所以都是同一个类加载器加载
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz1.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        //调用object1的方法 参数为object2
        method.invoke(object1, object2);
    }
}
