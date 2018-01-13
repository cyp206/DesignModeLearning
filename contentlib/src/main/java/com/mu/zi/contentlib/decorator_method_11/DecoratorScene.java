package com.mu.zi.contentlib.decorator_method_11;

/**
 * 修饰方法
 * Created by y on 2018/1/13.
 */

public class DecoratorScene {


    public DecoratorScene() {
        Component component = new ConcreteComponent();
        component = new Decorator1(component);
        component = new Decorator2(component);
        component.doSomething();
    }


    /**
     * 抽象组件类
     */
    public abstract class Component {

        public abstract void doSomething();

    }


    /**
     * 具体组件，被修饰的对象
     */
    public class ConcreteComponent extends Component {

        @Override
        public void doSomething() {
            System.out.println(" ConcreteComponent do something");

        }
    }


    /**
     * 基础修饰类
     */
    public class Decorator extends Component {

        private Component component;

        public Decorator(Component _component) {
            component = _component;
        }

        @Override
        public void doSomething() {
            component.doSomething();
        }
    }


    public class Decorator1 extends Decorator {

        public Decorator1(Component _component) {
            super(_component);
        }


        private void doSomeDecorate() {
            System.out.println(" Decorator1  进行 一次修饰");
        }


        @Override
        public void doSomething() {
            doSomeDecorate();
            super.doSomething();
        }
    }


    public class Decorator2 extends Decorator {


        public Decorator2(Component _component) {
            super(_component);
        }


        private void addSomeDecorate() {
            System.out.println("Decorator2 进行 一次修饰");

        }

        @Override
        public void doSomething() {
            addSomeDecorate();
            super.doSomething();
        }
    }


}
