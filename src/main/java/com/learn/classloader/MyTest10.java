package com.learn.classloader;

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        //不会触发该类初始化
        Parent2 parent2;

        System.out.println("-----------");

        //创建实例会触发初始化
        parent2 = new Parent2();

        System.out.println("-----------");
        //虽然调用了静态变量，但是该类已经在上面初始化过了，所以静态代码块不会执行
        System.out.println(parent2.a);
        System.out.println("-----------");
        System.out.println(Child.b);
    }
}
