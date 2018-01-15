package com.mu.zi.contentlib.adapter_pattern_13;

/**
 * 适配器模式
 * Created by y on 2018/1/15.
 */

public class AdapterPatternScene {


    /**
     * 场景
     */
    public   AdapterPatternScene() {
        Target target = new Adapter();
        Adaptee1 adaptee1 = new Adaptee1();
        Adaptee2 adaptee2 = new Adaptee2();
        Adaptee3 adaptee3 = new Adaptee3();
        Target target1 = new Adapter1(adaptee1, adaptee2, adaptee3);
        target.request();
        target1.request();
    }


    //    ------------单个源，适配器的简单实现

    /**
     * 目标接口
     */
    public interface Target {

        public void request();
    }


    /**
     * 适配器源
     */
    public class Adaptee {
        public void doSomething() {
            System.out.println("carry on doSomething method");
        }
    }


    /**
     * 适配器
     * 将适配源转换成target
     */
    public class Adapter extends Adaptee implements Target {


        @Override
        public void request() {
            doSomething();
        }
    }


    //    ------------扩展，多个源的时候，适配器的简单实现


    public class Adaptee1 {
        public void doSomething() {
            System.out.println("Adaptee1 carry on doSomething method");
        }
    }

    public class Adaptee2 {
        public void doSomething() {
            System.out.println("Adaptee2 carry on doSomething method");
        }
    }

    public class Adaptee3 {
        public void doSomething() {
            System.out.println("Adaptee3 carry on doSomething method");
        }
    }


    public class Adapter1 implements Target {

        private Adaptee2 adaptee2;
        private Adaptee3 adaptee3;
        private Adaptee1 adaptee1;

        public Adapter1(Adaptee1 adaptee1, Adaptee2 adaptee2, Adaptee3 adaptee3) {
            this.adaptee1 = adaptee1;
            this.adaptee2 = adaptee2;
            this.adaptee3 = adaptee3;

        }

        @Override
        public void request() {
            adaptee1.doSomething();
            adaptee2.doSomething();
            adaptee3.doSomething();
        }
    }

}
