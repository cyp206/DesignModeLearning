package com.mu.zi.contentlib.Iterator_pattern_13;

import java.util.ArrayList;

/**
 * 迭代器模式，建议用系统的，这里只是为了过一遍，简单些一下
 * Created by y on 2018/1/16.
 */

public class IteratorScene {


    public interface Iterator<E> {

        boolean hasNext();

        E next();

        E first();


    }


    public class ConcreteIterator<E> implements Iterator {

        private ArrayList<E> list;
        int cursor;
        private boolean hasNext;

        public ConcreteIterator(ArrayList list) {
            this.list = list;
            this.cursor = 0;

        }

        @Override
        public boolean hasNext() {
            hasNext = false;
            if (cursor >= 0 && cursor < list.size()) {
                hasNext = true;
            }

            return hasNext;
        }

        @Override
        public E next() {
            return list.get(cursor++);
        }

        @Override
        public E first() {
            return list.get(0);
        }


    }

    public interface Aggregate<E> {

        public void add(E e);

        public void remove(E e);

        public Iterator iterator();
    }

    public class ConcreteAggregate implements Aggregate<String> {

        private final ArrayList<String> list;

        public ConcreteAggregate() {
            list = new ArrayList<>();
        }

        @Override
        public void add(String s) {
            list.add(s);
        }

        @Override
        public void remove(String s) {
            list.remove(s);
        }

        @Override
        public Iterator iterator() {
            return new ConcreteIterator<String>(list);
        }
    }


    public IteratorScene() {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        concreteAggregate.add("1");
        concreteAggregate.add("2");
        concreteAggregate.add("3");
        concreteAggregate.add("4");
        concreteAggregate.add("5");
        concreteAggregate.add("6");
        concreteAggregate.add("7");
        Iterator<String> iterator = concreteAggregate.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }


    }


}
