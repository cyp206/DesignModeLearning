package com.mu.zi.contentlib;

import com.mu.zi.contentlib.decorator_method_11.DecoratorScene;
import com.mu.zi.contentlib.factory_method_2.Creator;
import com.mu.zi.contentlib.factory_method_2.PCreator;
import com.mu.zi.contentlib.factory_method_2.Product1;
import com.mu.zi.contentlib.factory_method_2.Product2;
import com.mu.zi.contentlib.mediator_method_8.MediatorScene;
import com.mu.zi.contentlib.request_chain_method_10.RequestChain;
import com.mu.zi.contentlib.single_1.Singleton;
import com.mu.zi.contentlib.single_1.SingletonLazy;
import com.mu.zi.contentlib.strategy_method_12.EnumStrategyScene;
import com.mu.zi.contentlib.strategy_method_12.StrategyScene;

public class MyClass {


    public static void main(String[] args) {
        EnumStrategyScene RequestCdhain = new EnumStrategyScene();
        StrategyScene RequestCdha = new StrategyScene();
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
