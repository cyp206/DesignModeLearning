package com.mu.zi.contentlib.single_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 奇葩的单例模式，采用静态块，加上放射实现实例。
 * Created by y on 2018/1/2.
 */

public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            Constructor constructor = cl.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static Singleton getSingleton() {
        return singleton;
    }
}
