package com.mu.zi.contentlib.p23_bridge_pattern;

/**
 * 桥梁模式   个人直接把他看错模板模式的变种
 * <p>
 * 该模式注重 解耦、自由重组
 * 注意 抽象角色 引用 一个实现角色。大概就是如此
 * Created by y on 2018/2/11.
 */

public class BridgePatternScene {

    public BridgePatternScene() {
        ConcreteImplementor implementor = new ConcreteImplementor();
        RefinedAbstractor refinedAbstractor = new RefinedAbstractor(implementor);
        refinedAbstractor.request();

    }

    //实现化角色
    public interface Implementor {
        void doSomething();

        void doAnything();
    }


    //具体实现类角色
    public class ConcreteImplementor implements Implementor {

        @Override
        public void doSomething() {

        }

        @Override
        public void doAnything() {

        }
    }


    /**
     * 抽象角色
     */
    public abstract class Abstraction {

        private Implementor implementor;

        public Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }


        public void request() {
            implementor.doAnything();
        }

        public Implementor getImplementor() {
            return implementor;
        }
    }


    /**
     * 修正抽象角色
     */
    public class RefinedAbstractor extends Abstraction {


        public RefinedAbstractor(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void request() {
            super.request();
            super.getImplementor().doSomething();

        }
    }

}
