package com.mu.zi.contentlib.abstract_factory_method_3;

/**
 * 热身，先来个一个案例
 * 女娲造人，普通工厂模式造了出了3种人，这个时候需要添加需求，即每种人有分男女
 * <p>
 * 实现思路通过创建两种不同的工厂，来创造出男人或者女人。
 * 由于一个人的属性中，性别是不一样的，所以需要抽取出来实现成对应的实体类。这里就引出了，抽象类定义公共方法，具体实现类实现其特殊方法。
 * <p>
 * 结构，以接口为本质（包括了共性和特性的定义，没有实现），抽象类为共性实现，具体类为特性实现。
 * <p>
 * <p>
 * Created by y on 2018/1/3.
 */

public class Science3 {


    /**
     * 接口人种
     */
    public interface Human {
        public void getColor();

        public void talk();

        public void getSex();


    }


    public abstract class AbstractWhiteHuman implements Human {

        public void getColor() {

            System.out.println("WhiteHuman is white");

        }

        public void talk() {
            System.out.println("WhiteHuman talk");

        }


    }

    public class MaleWhiteHuman extends AbstractWhiteHuman {

        @Override
        public void getSex() {
            System.out.println("MaleWhiteHuman");
        }
    }


    public class FemaleWhiteHuman extends AbstractWhiteHuman {

        @Override
        public void getSex() {
            System.out.println("FemaleWhiteHuman");

        }
    }

    /**
     * 接口 工厂
     */
    public interface HumanFactory {
        public Human createWhiteHuman();

    }


    public class MaleFactory implements HumanFactory {

        @Override
        public Human createWhiteHuman() {
            return new MaleWhiteHuman();
        }
    }


    public class FemaleFactory implements HumanFactory {

        @Override
        public Human createWhiteHuman() {
            return new FemaleWhiteHuman();
        }
    }


    public Science3() {

        HumanFactory maleFactory = new MaleFactory();

        Human whiteHuman = maleFactory.createWhiteHuman();
        whiteHuman.getSex();


        HumanFactory femaleFactory = new FemaleFactory();

        Human whiteHuman1 = femaleFactory.createWhiteHuman();
        whiteHuman1.getSex();

    }
}

