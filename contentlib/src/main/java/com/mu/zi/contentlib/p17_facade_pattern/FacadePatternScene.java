package com.mu.zi.contentlib.p17_facade_pattern;

/**
 * 门面模式
 * 代码很简单，主要就是封装思想，即上下级依赖的关系。子系统中的业务逻辑随意改变，记住门面是不能随意变动的。这样保证了上级依赖的稳定性
 * <p>
 * Created by y on 2018/1/19.
 */

public class FacadePatternScene {

    public FacadePatternScene() {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }

    /**
     * 子系统A
     */
    public class ClassA {

        public void doSomething() {
            System.out.println(getClass().getSimpleName() + "doSomething");
        }
    }

    /**
     * 子系统B
     */
    public class ClassB {

        public void doSomething() {
            System.out.println(getClass().getSimpleName() + "doSomething");
        }
    }

    /**
     * 子系统C
     */
    public class ClassC {

        public void doSomething() {
            System.out.println(getClass().getSimpleName() + "doSomething");
        }
    }

    /**
     * 门面
     */
    public class Facade {


        private ClassA a = new ClassA();
        private ClassB b = new ClassB();
        private ClassC c = new ClassC();


        public void methodA() {
            a.doSomething();
        }

        public void methodB() {
            b.doSomething();

        }

        public void methodC() {
            c.doSomething();
        }

    }

}
