package com.learn.classloader;

import java.lang.reflect.Method;

public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/users/liujin/desktop/");
        loader2.setPath("/users/liujin/desktop/");

        Class<?> clazz1 = loader1.loadClass("com.learn.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.learn.classloader.MyPerson");

        //false因为虽然两个都是MyTest16 但是是两个实例，而两者之间并没有类似双亲的父子关系，所以是相互独立的，各自的命名空间只能看到自己的
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz1.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        //这里会报错，因为object1，object2分别有不同的clazz创建而在上下文中他们是互相不可见的，所以这里就会报错
        method.invoke(object1, object2);
    }
}
