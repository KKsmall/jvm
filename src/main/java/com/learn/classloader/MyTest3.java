package com.learn.classloader;

import java.util.UUID;

public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
//  一个常量的值无法在编译期确定，那么其值就不会放入调用类的常量池中，当程序运行时，、
//  会导致主动使用在常量所在的类，也就导致该类被初始化
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }
}
