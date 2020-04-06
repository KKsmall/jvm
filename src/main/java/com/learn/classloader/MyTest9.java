package com.learn.classloader;

class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

/**
 * 打印结果
 * MyTest9 static block
 * Parent static block
 * Child static block
 * 4
 * 首先调用main方法会触发MyTest9的初始化，然后调用Child.b 由于b是静态变量，初始化是要先初始化父类，然后自己初始化完成时初始化静态代码块最后初始化b
 */
