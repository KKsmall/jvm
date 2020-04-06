package com.learn.classloader;

/**
 * 命名空间的说明
 * 命名空间是自身的类加载器和所有父类加载器组成的命名空间
 * 子加载器所加载的类能够访问到父加载的类，反之不能
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat classLoader is:" + this.getClass().getClassLoader());

        /*
        如果该项目下的MySample.class文件移动到其他盘，MyTest17自定义类加载器启动时，会先加载MySample，由于委托父类都找不到，
        最终是自定义类加载器在其他盘加载，由于触发了MySample的构造方法，继而激活MyCat的构造方法，虽然加载MyCat也是用的自定义加载器,
        但是需要先委托给父加载器即App加载器，它在该项目路径下能找到MyCat.class所以就用的父类加载器加载，正是因为用的app加载器加载，
        由于父类看不到子类加载的类，所以用子类MyTest17加载的MySample类是看不到的，所以会报找不到类的异常
         */
       // System.out.println("from MyCat: " + MySample.class);
    }
}
