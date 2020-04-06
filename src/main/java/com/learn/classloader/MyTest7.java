package com.learn.classloader;

public class MyTest7 {
    public static void main(String[] args) throws Exception{
        //打印为null说明他是有根类加载器加载
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazzC = Class.forName("com.learn.classloader.C");
        System.out.println(clazzC.getClassLoader());
    }
}
class C {

}