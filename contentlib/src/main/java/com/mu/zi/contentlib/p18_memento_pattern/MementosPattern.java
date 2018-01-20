package com.mu.zi.contentlib.p18_memento_pattern;

import java.util.HashMap;

/**
 * 多份备份的备忘录
 * <p>
 * Created by y on 2018/1/20.
 */

public class MementosPattern {


    public MementosPattern() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setName("天");
        caretaker.addMemento("1", originator.createMemento());
        originator.setName("地");
        caretaker.addMemento("2", originator.createMemento());

        originator.setName("人");
        caretaker.addMemento("3", originator.createMemento());

        originator.setName("和");
        caretaker.addMemento("4", originator.createMemento());


        originator.restore(caretaker.getMemento("2"));
        originator.print();


    }


    /**
     * 加一个接口是为了封闭备份数据，让其他层级无法访问内部数据
     */
    public interface BaseMemento {


    }


    /**
     * 数据源
     * 有个内部类备忘录，并且备忘录实现了一个空接口。
     */
    public class Originator {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void restore(BaseMemento memento) {
            setName(((Memento) memento).getStatue());
        }

        public BaseMemento createMemento() {
            return new Memento(getName());
        }

        public class Memento implements BaseMemento {

            private String statue;

            public Memento(String s) {
                statue = s;
            }

            public String getStatue() {
                return statue;
            }
        }

        public void print() {
            System.out.println("name ++>" + name);
        }

    }

    /**
     * 备份 管理，key 可以理解成时间戳或者其他标记，实现多备忘录管理
     */
    public class Caretaker {
        HashMap<String, BaseMemento> mementoHashMap = new HashMap<>();


        public void addMemento(String key, BaseMemento memento) {
            mementoHashMap.put(key, memento);

        }

        public BaseMemento getMemento(String key) {
            if (mementoHashMap.containsKey(key)) {
                return mementoHashMap.get(key);

            }
            return null;
        }

    }
}
