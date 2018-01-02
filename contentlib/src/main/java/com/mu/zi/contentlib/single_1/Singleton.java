package com.mu.zi.contentlib.single_1;

/**
 * 单例之饿汉模式
 * Created by y on 2018/1/2.
 */

public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;

    }


    public void doSomething() {
        System.out.println("我是饿汉模式单例");
    }

}
