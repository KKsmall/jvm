package com.learn.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器 必须继承ClassLoader
 */
public class MyTest16 extends ClassLoader{

    //该自定义类加载器的名称
    private String classLoaderName;

    private String path;

    private String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        //这里显示调用父类的构造方法，是为了创建新的类加载器作为该自定义类加载器的父类
        //这个构造方法默认是创建的SystemClassLoader
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        //这个是指定某个类加载器作为该自定义类加载的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className){
        System.out.println("---进入重写啦----");
        byte[] data = loadClassData(className);
        //通过该方法定义出我们所要的Class实例
        return defineClass(className, data, 0, data.length);
    }

    //先把.class文件转成字节数组
    private byte[] loadClassData(String name) {
        InputStream ins = null;
        byte[] data = null;
        ByteArrayOutputStream aos = null;

        try {
            //因为我们要从磁盘上获取到该文件所以路径要替换成/的形式  如果是linux下也要做替换
            name = name.replace(".", "/");
//            String path = "/Users/liujin/Desktop/";
//            ins = new FileInputStream(new File(path + name + this.fileExtension));
            ins = new FileInputStream(new File(name + this.fileExtension));

            int ch;

            while (-1 != (ch = ins.read())) {
                aos.write(ch);
            }
            data = aos.toByteArray();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                aos.close();
                ins.close();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        //假如我们想用这个自定义类加载器加载MyTest1
        //这里为什么没看到调用我们的findClass方法呢？
        // 因为在loadClass方法中就有对这些方法的调用，只是是模板方法，所以我们这里重写后里面就会调用我们这边写的方法
        //不过这里其实并没有调用重写的find方法,因为当前项目下已经生成了该类的.class文件，根据双亲委派模式，会先丢给系统类加载器器，而该父加载器扫描的就是当前项目下的，
        // 能找到父类加载器就直接加载了，所以没有触发我们重写的，可以尝试把该class文件删除，复制到系统其它盘，然后find方法读取其他盘的文件路径，这样自定义的父类加载器都找不到，最终就会执行到自定义加载器
        Class<?> clazz = classLoader.loadClass("com.learn.classloader.MyTest1");
        Object object = clazz.newInstance();

        System.out.println(object);
    }

    //打印结果com.learn.classloader.MyTest1@4554617c  说明test1类被我们自定义的类加载加载成功
    public static void main(String[] args) throws Exception {
        MyTest16 myTest16 = new MyTest16("classloader1");
        test(myTest16);

        //这里在new的新的自定义加载类的话，如果test方法里加载的类是在其他盘下，虽然和上面的test一样都是调用的自定义加载类的loadClass方法，不过加载两次该类，
        // 因为他们虽然都是自定义加载类但是是分别new出来的，所以调用loadClass的命名空间是不一样的
        MyTest16 myTest2 = new MyTest16("classloader1");
        test(myTest2);

        //这种方式因为设置了父加载器，运行main方法是第一次调用test会加载指定的类，然后这里由于双亲委托机制会委托给父加载器，而父加载器加载过了，
        // 所以就能直接拿父加载器加载的结果
        MyTest16 myTest3 = new MyTest16(myTest16, "loader2");
        test(myTest3);
    }
}
