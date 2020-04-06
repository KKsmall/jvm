package com.learn.classloader;

import java.util.Random;
import java.util.UUID;

/**
 * 接口中对类的主动使用不要求父类一定要初始化，
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    public static  final int a = new Random().nextInt();
}

interface MyChild5 extends MyParent5 {
    int b = 5;
}
