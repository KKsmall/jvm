package com.learn.classloader;

/**
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印
 *
 * -XX:+<option>,表示开启option选项
 * -XX:-<option>,表示关闭option选项
 * -XX:<option>=<value>,表示option设置为value
 */
public class MyTest1 {

    public static void main(String[] args) {
        //对于静态字段来说，只有直接定义了该字段的类才会被初始化,虽然是子类调用但是字段是父类的，所以子类的静态块没打印，但是这个子类有被加载
//        System.out.println(MyChild1.str);
        //这里是主动使用了子类的静态字段，对子类做初始化前会对父类做初始化，所以父类的静态块也被打印
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {

    public static String str = "hello word";

    static {
        System.out.println("MyParent1 is block");
    }
}

class MyChild1 extends MyParent1 {

    public static String str2 = "hello word 2";

    static {
        System.out.println("MyChild1 is block");
    }
}