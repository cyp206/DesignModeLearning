package com.mu.zi.contentlib.single_1;

/**
 * 单例模式之懒汉模式
 * Created by y on 2018/1/2.
 */

public class SingletonLazy {

    private static SingletonLazy singletonLazy;


    private SingletonLazy() {

    }

    public static synchronized SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();

        }
        return singletonLazy;

    }

    public void doSomething() {
        System.out.println("我是懒汉模式单例");
    }


}
