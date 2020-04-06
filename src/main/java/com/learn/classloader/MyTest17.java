package com.learn.classloader;

/*8
    打印结果：
    1956725890
MySample classLoader is: sun.misc.Launcher$AppClassLoader@18b4aac2
MyCat classLoader is:sun.misc.Launcher$AppClassLoader@18b4aac2
    结论：
    虽然创建的是自定义的类加载器，但是没有指定类加载的路径，默认委托给父类应用类加载器在当前项目中加载.class文件，
    由于能找到所有就加载了
 */
public class MyTest17 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader = new MyTest16("loader");
        Class<?> clazz = loader.loadClass("com.learn.classloader.MySample");
        System.out.println(clazz.hashCode());
        //获得clazz对象后通过反射创建类实例激活了MySample的构造方法，也激活了new MyCat
        Object o  = clazz.newInstance();
    }
}
