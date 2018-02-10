package com.mu.zi.contentlib;

import com.mu.zi.contentlib.p1_single.Singleton;
import com.mu.zi.contentlib.p1_single.SingletonLazy;
import com.mu.zi.contentlib.p21_interpreter_pattern.SubAndAddInterpreter;
import com.mu.zi.contentlib.p2_factory_method.Creator;
import com.mu.zi.contentlib.p2_factory_method.PCreator;
import com.mu.zi.contentlib.p2_factory_method.Product1;
import com.mu.zi.contentlib.p2_factory_method.Product2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MyClass {


    public static void main(String[] args) {
//        SubAndAddInterpreter CompositePatternScene = new SubAndAddInterpreter();
//        BigInteger bigInteger = BigInteger.valueOf(0x0000000000000000000000000000000000000000000000056bc75e2d63100000);
        BigDecimal b =new BigDecimal(2);
        System.out.println(b.toBigInteger().bitCount());

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
