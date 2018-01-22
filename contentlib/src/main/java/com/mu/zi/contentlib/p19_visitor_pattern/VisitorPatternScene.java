package com.mu.zi.contentlib.p19_visitor_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 访问者模式
 * 用于类拓展
 * <p>
 * 主要元素
 * visitor 访问者，调用被访问对象，根据具体需求重新使用被访问者元素实现需求
 * element 被访问者
 * object struct  被访问者容器
 * Created by y on 2018/1/21.
 */

public class VisitorPatternScene {

    public VisitorPatternScene() {


        ObjectStruct struct = new ObjectStruct();
        Visitor visitor = new IVisitor();
        struct.visit(visitor);


    }


    public class ObjectStruct {

        private List<Element> list;

        public ObjectStruct() {
            list = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 50; i++) {
                if (random.nextInt() % 2 == 0) {
                    list.add(new ConcreteElement1());
                } else {
                    list.add(new ConcreteElement2());
                }

            }
        }

        public void visit(Visitor v) {

            for (Element e : list) {
                e.accept(v);
            }

        }

    }


    public interface Visitor {
        void visit(ConcreteElement1 c1);

        void visit(ConcreteElement2 c2);
    }

    public class IVisitor implements Visitor {

        @Override
        public void visit(ConcreteElement1 c1) {
            c1.doSomething();
            c1.doSomething();

        }

        @Override
        public void visit(ConcreteElement2 c2) {
            c2.doSomething();
            c2.doSomething();
        }
    }

    public interface Element {

        void doSomething();

        void accept(Visitor v);

    }


    public class ConcreteElement1 implements Element {

        @Override
        public void doSomething() {
            System.out.println("ConcreteElement1 do Something");

        }

        @Override
        public void accept(Visitor v) {
            v.visit(this);

        }
    }

    public class ConcreteElement2 implements Element {

        @Override
        public void doSomething() {
            System.out.println("ConcreteElement2 do Something");
        }

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
    }


}
