package com.mu.zi.contentlib.strategy_method_12;

/**
 * 策略模式
 * 简单来说，一般看到context这个上下文的时候，这个场景就很有可能是策略模式。
 * 策略模式是面向对象 继承和多态的体现。
 * context 中封装了各种各样的策略，让其他场景通过context来实现需求。
 * <p>
 * Created by y on 2018/1/14.
 */

public class StrategyScene {

    public StrategyScene(){
        Strategy strategy =new ConcreteStrategy();
        Context context = new Context(strategy);
        context.doSomething();
    }


    public interface Strategy {
        public void doSomething();
    }

    public class ConcreteStrategy implements Strategy {

        @Override
        public void doSomething() {
            System.out.println("ConcreteStrategy do something");
        }
    }

    public class Context {

        private Strategy strategy;

        public Context(Strategy _strategy) {
            strategy = _strategy;
        }


        public void doSomething() {
            strategy.doSomething();
        }
    }






}
