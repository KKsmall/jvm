package com.learn.classloader;

public class MyTest24 {

    /**
     * 打印结果：
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * null
     * 结论：
     *      线程上下文类加载器，如果没有设置的话，线程将继承父线程的上下文类加载器。java应用运行时的初始线程的上下文类加载器是系统类加载器
     *      在线程中运行的代码可以通过该类加载器来加载类与资源，其中的重要作用是打破了双亲委托机制。因为在双亲委托机制中父加载器是看不见子加载器
     *      加载的资源，有一些服务提供接口（spi）是java和核心库提供，而实现却来自不同jar包，通过上线文加载器就可以有设置的上下文类加载器来实现对于接口实现类的加载
     *
     *      第二行是因为Thread是在rt.jar包下有启动类加载器加载
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
