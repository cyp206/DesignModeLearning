package com.mu.zi.contentlib.abstract_factory_method_3;

/**
 * 抽象工程模板，有点乱，让我静静-。-！！！！
 * Created by y on 2018/1/3.
 */

public class AbstractFactoryScience {


    public abstract class AbstractProductA {

        //公共方法
        public void publicMethod() {
            System.out.println(" 此乃A 公共方法也！");
        }

        abstract void selfMethod();
    }

    public abstract class AbstractProductB {

        //公共方法
        public void publicMethod() {
            System.out.println(" 此乃B公共方法也！");
        }

        abstract void selfMethod();
    }


    public class ProductA1 extends AbstractProductA {

        @Override
        void selfMethod() {
            System.out.println(" 此乃 产品A1 的私人方法！");
        }
    }

    public class ProductA2 extends AbstractProductA {

        @Override
        void selfMethod() {
            System.out.println(" 此乃 产品A2 的私人方法！");
        }
    }


    public class ProductB1 extends AbstractProductB {

        @Override
        void selfMethod() {
            System.out.println(" 此乃 产品B1 的私人方法！");
        }
    }

    public class ProductB2 extends AbstractProductB {

        @Override
        void selfMethod() {
            System.out.println(" 此乃 产品B2 的私人方法！");
        }
    }


    public abstract class AbstractCreator {
        public abstract AbstractProductA createProductA();

        public abstract AbstractProductB createProductB();

    }

    public class Creator1 extends AbstractCreator {
        @Override
        public AbstractProductA createProductA() {
            return new ProductA1();
        }

        @Override
        public AbstractProductB createProductB() {
            return new ProductB1();
        }
    }

    public class Creator2 extends AbstractCreator {
        @Override
        public AbstractProductA createProductA() {
            return new ProductA2();
        }

        @Override
        public AbstractProductB createProductB() {
            return new ProductB2();
        }
    }


    /**
     * 两条产品线，创建出四种产品类喵！
     */
    public AbstractFactoryScience() {

        Creator1 creator1 = new Creator1();
        creator1.createProductA();
        creator1.createProductB();

        Creator2 creator2 = new Creator2();
        creator2.createProductA();
        creator2.createProductB();

    }


}
