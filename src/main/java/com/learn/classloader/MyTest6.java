package com.learn.classloader;

public class MyTest6 {
    public static void main(String[] args) {
        //对静态方法的调用就是主动使用，会对类进行初始化
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);
    }
}

/*
    在对类进行初始化前的准备阶段，会给相应的字段赋值默认值，此时counter1 2默认值都为0 所以++后的结果都为1
 */
class Singleton {
    public static int counter1;
    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;

        System.out.println(counter1);
        System.out.println(counter2);
    }
//    如果把上面的counter2放到构造方法的下面，输出的main输出的结果counter2是0，
//    因为在初始化是按顺序下来的，虽然默认值为0初始化后被++ 但是这里等于把它又初始化为0
//    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
