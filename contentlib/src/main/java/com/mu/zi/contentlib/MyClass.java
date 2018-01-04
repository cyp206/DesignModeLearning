package com.mu.zi.contentlib;

import com.mu.zi.contentlib.abstract_factory_method_3.Science3;
import com.mu.zi.contentlib.factory_method_2.Creator;
import com.mu.zi.contentlib.factory_method_2.PCreator;
import com.mu.zi.contentlib.factory_method_2.Product1;
import com.mu.zi.contentlib.factory_method_2.Product2;
import com.mu.zi.contentlib.single_1.Singleton;
import com.mu.zi.contentlib.single_1.SingletonLazy;

public class MyClass {


    public static void main(String[] args) {
        Science3 Science3 = new Science3();
    }


    /**
     * 工厂模式
     */
    private static void factoryMethod() {
        Creator creator = new PCreator();
        Product2 product = creator.createProduct(Product2.class);
        Product1 product1 = creator.createProduct(Product1.class);
        product.method();
        product1.method();
    }


    /**
     * 单例模式
     */

    private static void singleMethod() {
        Singleton.getInstance().doSomething();
        SingletonLazy.getInstance().doSomething();


    }
}
