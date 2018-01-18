package com.mu.zi.contentlib.p16_observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * 思想：  开关 与 灯光的亮暗  ==》 开关开  灯光亮   开关关  灯光暗，开关是被监听  灯光是监听者
 *
 * TIP：  java api中已近有 Observer 和 Observable 接口了，想要用直接实现接口就好了。
 *
 * Created by y on 2018/1/18.
 */

public class ObserverScene {


    public ObserverScene() {

        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(concreteObserver);
        observable.doSomething();
    }


    /**
     * 观察者
     */
    public abstract class Observer {
        public abstract void update();
    }


    public class ConcreteObserver extends Observer {

        @Override
        public void update() {
            System.out.println("有情况，那个傻逼开始动了 -  - -  -");
        }
    }


    /**
     * 被观察者
     */
    public abstract class Observable {
        List<Observer> observers = new ArrayList<>();


        public void addObserver(Observer obs) {
            observers.add(obs);
        }

        public void removeObserver(Observer obs) {
            observers.remove(obs);
        }


        public abstract void notifyObservers();

    }


    public class ConcreteObservable extends Observable {
        public void doSomething() {
            System.out.println("biu  biu  biu  开始行动");

            notifyObservers();
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }


}
