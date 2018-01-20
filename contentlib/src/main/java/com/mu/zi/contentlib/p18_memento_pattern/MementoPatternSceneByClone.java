package com.mu.zi.contentlib.p18_memento_pattern;

/**
 * 利用克隆实现备忘录
 * Created by y on 2018/1/20.
 */

public class MementoPatternSceneByClone {


    public MementoPatternSceneByClone() {
        Originator originator = new Originator("天");
        Caretaker caretaker = new Caretaker(originator.createMemento());
        originator.setStatue("wo can i do for myself");
        originator.restoreMemento(caretaker.getOri());
        originator.print();

    }


    /**
     * 源
     */
    public class Originator implements Cloneable {


        String statue = "-1";

        public String getStatue() {
            return statue;
        }

        public void setStatue(String statue) {
            this.statue = statue;
        }

        public Originator(String statue) {

            this.statue = statue;
        }

        @Override
        protected Originator clone() throws CloneNotSupportedException {
            return (Originator) super.clone();
        }


        public Originator createMemento() {
            try {
                return clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void restoreMemento(Originator originator) {
            setStatue(originator.getStatue());

        }

        public void print() {
            System.out.println("statue:" + statue);
        }
    }

    /**
     * 备忘录管理者
     */
    public class Caretaker {
        private Originator ori;

        public Caretaker(Originator ori) {
            this.ori = ori;
        }

        public Originator getOri() {
            return ori;
        }

        public void setOri(Originator ori) {
            this.ori = ori;
        }
    }

}
