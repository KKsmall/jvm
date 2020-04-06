package com.learn.classloader;

/**\
 * 数组没有类加载器，是jvm在运行期创建，数组的类加载器等同于数组元素的类加载器
 * 打印结果
 * null
 * --------
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * --------
 * null
 * 结论：
 * Sring使用根类加载器加载所以打印null
 * MyTest15是由应用加载器在家
 * int是原生类型，是没有加载器的，这里的null指的的是没有加载器而不是指的根类加载器
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("--------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("--------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
