package com.mu.zi.contentlib.p12_strategy_method;

/**
 * 枚举策略模式
 * 通过枚举写法实现各种策略
 *
 * 通过这个例子，对枚举又加深了理解。
 *
 * 《《每一个枚举可以理解成这个枚举类的实例。》》
 *
 * Created by y on 2018/1/14.
 */

public class EnumStrategyScene {

    public EnumStrategyScene() {
        STRATEGY.ACTION_1.doSomething();
        STRATEGY.ACTION_2.doSomething();
    }

    public enum STRATEGY {
        ACTION_1("action_1") {
            @Override
            public void doSomething() {
                System.out.println(getValue());
            }
        }, ACTION_2("action_2") {
            @Override
            public void doSomething() {
                System.out.println(getValue());
            }
        };

        private String value;

        private STRATEGY(String value) {
            this.value = value;
        }

        public abstract void doSomething();

        public String getValue() {
            return value;
        }


    }

}
