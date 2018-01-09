package com.mu.zi.contentlib.proxy_method_6;

/**
 * 强制代理类
 * 特点
 * 1、真实主题无法直接被调用。
 * 2、可以通过真实主题返回代理类。
 * 3、代理类来管理操作真实主题。
 * Created by y on 2018/1/8.
 */

public class ForceProxyScene {


    public ForceProxyScene() {

        Subject realSubject = new RealSubject("xun lei dai li ");
        Subject proxy = realSubject.getProxy();
        realSubject.request(new ForceProxy(realSubject));
        proxy.request(proxy);
    }


    public interface Subject {
        void request(Subject subject);

        Subject getProxy();

    }


    public class ForceProxy implements Subject {
        private Subject realSubject;

        public ForceProxy(Subject subject) {
            realSubject = subject;

        }

        @Override
        public void request(Subject subject) {
            realSubject.request(this);
        }

        @Override
        public Subject getProxy() {
            return this;
        }


    }

    public class RealSubject implements Subject {
        Subject proxy;
        String name;

        public RealSubject(String name) {
            proxy = new ForceProxy(this);
            this.name = name;
        }

        @Override
        public void request(Subject subject) {
            if (subject == proxy) {
                System.out.println("小秘为您服务，我已经替我家boss做好了你的要求 ！！");
            } else {
                System.out.println("请找我的小秘，我是boss不处理这些事情的！！");
            }
        }

        @Override
        public Subject getProxy() {
            return proxy;
        }
    }

}
