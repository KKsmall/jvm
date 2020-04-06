package com.learn.classloader;

public class MySample {

    public MySample() {
        System.out.println("MySample classLoader is: " + this.getClass().getClassLoader());

        new MyCat();
    }
}
