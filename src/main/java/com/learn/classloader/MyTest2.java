package com.learn.classloader;

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str2);
    }
}

class MyParent2 {
//    public static String str = "hello word";
    //这里使用final后说明该字段是常量，在编译阶段会存入到调用该常量的方法所在类的常量池中，
// 这里是main方法调用的它也就是该常量是存在MyTest2的常量池中，调用类并没有直接引用到定义常量的类，
// 因此不会触发定义常量的类的初始化，所以该类的静态块没有打印
    public static final String str2 = "hello word";

    static {
        System.out.println("MyParent2 static block");
    }
}
