package com.mu.zi.contentlib.p8_mediator_method;

/**
 * 中介者模式
 * Created by y on 2018/1/10.
 */

public class MediatorScene {


    public MediatorScene() {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(concreteMediator);
        concreteMediator.setColleague1(colleague1);
        concreteMediator.setColleague2(colleague2);
        colleague1.publicMethod();
        colleague2.publicMethod();


    }


    /**
     * 同事成员抽象类
     */
    public abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }

    }

    /**
     * 具体同事成员1
     */
    public class ConcreteColleague1 extends Colleague {


        public ConcreteColleague1(Mediator mediator) {
            super(mediator);
        }

        public void selfMethod() {
            System.out.println("colleague1 do selfMethod");
        }

        public void publicMethod() {
            super.mediator.doSomething1();

        }

    }

    /**
     * 具体同事成员2
     */
    public class ConcreteColleague2 extends Colleague {


        public ConcreteColleague2(Mediator mediator) {
            super(mediator);
        }

        public void selfMethod() {
            System.out.println("colleague2 do selfMethod");

        }

        public void publicMethod() {
            super.mediator.doSomething2();
        }
    }

    /**
     * 抽象的中介
     */
    public abstract class Mediator {

        protected ConcreteColleague1 colleague1;
        protected ConcreteColleague2 colleague2;


        public abstract void doSomething1();

        public abstract void doSomething2();


        public ConcreteColleague1 getColleague1() {
            return colleague1;
        }

        public void setColleague1(ConcreteColleague1 colleague1) {
            this.colleague1 = colleague1;
        }

        public ConcreteColleague2 getColleague2() {
            return colleague2;
        }

        public void setColleague2(ConcreteColleague2 colleague2) {
            this.colleague2 = colleague2;
        }
    }

    /**
     * 具体的中介对象
     */
    public class ConcreteMediator extends Mediator {

        @Override
        public void doSomething1() {
            super.colleague1.selfMethod();
            super.colleague2.selfMethod();
        }

        @Override
        public void doSomething2() {
            super.colleague1.selfMethod();
            super.colleague2.selfMethod();
        }
    }


}
