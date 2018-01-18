package com.mu.zi.contentlib.p4_template_method_pattern;

/**
 * Created by y on 2018/1/4.
 */

public class TemplateMethod {


    public abstract class AbstractClass {

        //通用方法
        final void doSomething() {

            System.out.println("is public method");

        }


        protected abstract void doAnything();


    }


    public class Class1 extends AbstractClass {

        @Override
        protected void doAnything() {
            System.out.println("Class1 doAnything");

        }
    }


    public class Class2 extends AbstractClass {

        @Override
        protected void doAnything() {
            System.out.println("Class2 doAnything");

        }
    }


    public TemplateMethod() {
        AbstractClass a1 = new Class1();
        a1.doAnything();
        AbstractClass a2 = new Class1();
        a2.doAnything();

    }
}
