package com.mu.zi.contentlib;

import com.mu.zi.contentlib.p14_Iterator_pattern.IteratorScene;
import com.mu.zi.contentlib.p15_composite_pattern.CompositePatternScene;
import com.mu.zi.contentlib.p16_observer_pattern.ObserverScene;
import com.mu.zi.contentlib.p2_factory_method.Creator;
import com.mu.zi.contentlib.p2_factory_method.PCreator;
import com.mu.zi.contentlib.p2_factory_method.Product1;
import com.mu.zi.contentlib.p2_factory_method.Product2;
import com.mu.zi.contentlib.p1_single.Singleton;
import com.mu.zi.contentlib.p1_single.SingletonLazy;

public class MyClass {


    public static void main(String[] args) {
        ObserverScene CompositePatternScene = new ObserverScene();
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

    public   void ss(){

    }
}
