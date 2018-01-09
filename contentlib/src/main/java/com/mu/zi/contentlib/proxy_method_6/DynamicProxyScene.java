package com.mu.zi.contentlib.proxy_method_6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理（有得玩了）
 * Created by y on 2018/1/8.
 */

public class DynamicProxyScene {


    public DynamicProxyScene() {
        Subject subject = new RealSubject("张三");
        //定义一个handler

//        Subject proxy = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, handler);
        //这里为了写入方便，正常代理管理类为静态的方法类，方便调用
        DynamicProxy<Subject> dynamicProxy = new DynamicProxy();
        Subject proxy = dynamicProxy.newProxyInstance(subject);


        if (proxy == subject) {
            System.out.println("proxy ==subject");
        } else {
            System.out.println("proxy !=subject");

        }
        proxy.request();
    }


    /**
     * 抽象主题
     */
    public interface Subject {
        void request();
    }


    /**
     * 真实主题
     */
    public class RealSubject implements Subject {

        private String name;

        public RealSubject(String name) {
            this.name = name;
        }

        @Override
        public void request() {
            System.out.println("RealSubject do some request");
        }
    }


    /**
     * 代理管理和生成类
     * 注意：一般情况下，生成代理实例的方法一般写成静态类，方便调用。这里为了写demo，没有进行static化
     *
     * @param <T>
     */
    public class DynamicProxy<T> {

        public <T> T newProxyInstance(Object obj) {
            if (obj == null) return null;
            //添加一个切面点

            if (true) {
                //todo something 进行前置消息设置
            }

            InvocationHandler handler = new SubjectHandler(obj);

            return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

        }
    }

    /**
     * invocation实现类
     */
    public class SubjectHandler implements InvocationHandler {
        //被代理者
        Class cls = null;
        //被代理的实例
        Object obj = null;

        //我要代理谁
        public SubjectHandler(Object obj) {
            this.obj = obj;
        }

        /**
         * 调用被代理的方法(InvocationHandler的实现类)
         * 按我的理解每次调用代理类的某个接口方法的时候，invoke都被调用一次
         *
         * @param o
         * @param method
         * @param objects
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            Object result = method.invoke(this.obj, objects);

            System.out.println("代理正在调用request方法");


            if (method.getName().equalsIgnoreCase("request")) {
                System.out.println("代理正在调用request方法");

            }
            return result;
        }


    }

    public interface SB {
        void method1();

        void method2();
    }

    public class  SBImpl  implements SB{

        @Override
        public void method1() {
            System.out.println("method1 do something");
        }

        @Override
        public void method2() {
            System.out.println("method2 do something");

        }
    }

    public class Scene{

        public Scene(){



        }
    }

}
