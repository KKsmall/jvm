package com.learn.classloader;

public class MyTest4 {
    public static void main(String[] args) {
//      首次主动使用，这里创建实例会导致初始化，myParent5是主动使用但已经不是第一次了所以不会再打印
        MyParent4 myParent4 = new MyParent4();
        MyParent4 myParent5 = new MyParent4();

//      数组也是不会初始化类对象的，因为它不属于主动使用里的7种方式，是java虚拟机在运行时动态生成的
        //以[Lcom.xxx.xxx的形式一个[表示数组 2个就是二维，动态生成的类型，其父类是Object
        MyParent4[] myParent4s = new MyParent4[1];
    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
