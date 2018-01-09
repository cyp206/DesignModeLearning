package com.mu.zi.contentlib.proxy_method_6;

/**
 * 普通的代理模式
 * 1、生成真是主题的时候，需要判断是否已经生成代理类
 *
 * Created by y on 2018/1/8.
 */

public class CommonProxyScene {


    public CommonProxyScene() {

        CommonProxySubject proxy = new CommonProxySubject("proxy a ");
        proxy.request();


    }

    // 抽象主题
    public interface Subject {
        public void request();

    }


    public class RealSubject implements Subject {

        private String name;

        public RealSubject(Subject subject, String s) {
            if (subject == null) throw new RuntimeException("没有指定代理类");
            name = s;
        }

        @Override
        public void request() {
            System.out.println("RealSubject do something");
        }
    }


    public class CommonProxySubject implements Subject {

        private Subject realSubject = null;

        public CommonProxySubject(String name) {
            realSubject = new RealSubject(this, name);
        }

        @Override
        public void request() {
            if (realSubject == null) return;
            realSubject.request();
        }
    }

}
