package com.mu.zi.contentlib.p6_proxy_method;

/**
 * 代理类的基本核心就是让别人来管理你的东西，类似游戏代练，官司代打。
 * Created by y on 2018/1/6.
 */

public class ProxyScene {


    public ProxyScene() {
        //创建真实主题
        RealSubject realSubject = new RealSubject();
        //创建代理类，并且设置被代理的对象。
        ProxySubjcet proxySubjcet = new ProxySubjcet(realSubject);
        //通过代理类，来调用真是主题的方法。
        proxySubjcet.request();

    }


    //抽象主题，针对具体业务定下的条目。
    public interface Subject {
        void request();
    }

    //真是主题，也可以称之为被代理的对象。
    public class RealSubject implements Subject {

        @Override
        public void request() {
            System.out.println("realSubject request");
        }
    }


    //代理类
    public class ProxySubjcet implements Subject {


        private Subject subject;

        public ProxySubjcet() {

            subject = new RealSubject();
        }


        public ProxySubjcet(Subject subject) {

            this.subject = subject;

        }


        @Override
        public void request() {
            this.subject.request();
        }
    }


}
