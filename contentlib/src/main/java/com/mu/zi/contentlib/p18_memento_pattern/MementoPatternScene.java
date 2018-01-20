package com.mu.zi.contentlib.p18_memento_pattern;

/**
 * 备忘录模式
 * 游戏中常做的事情  save-load  大法
 * 以下是基础模板
 * Created by y on 2018/1/20.
 */

public class MementoPatternScene {

    public MementoPatternScene() {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator.createMemento());
        originator.setStatue("天");
        originator.setStatue("地");
        originator.setStatue("人");
        originator.setStatue("和");
        originator.restoreMemento(caretaker.getMemento());

    }

    /**
     * 源
     */
    public class Originator {

        private String statue = "-1";

        public String getStatue() {
            return statue;
        }

        public void setStatue(String statue) {
            this.statue = statue;
        }

        public void restoreMemento(Memento memento) {
            setStatue(memento.getStatue());
        }

        public Memento createMemento() {
            return new Memento(statue);
        }

        public void printStatue() {
            System.out.println("statue" + statue);
        }


    }

    /**
     * 备忘录
     */
    public class Memento {
        private String statue;

        public Memento(String statue) {
            this.statue = statue;
        }


        public String getStatue() {
            return statue;
        }

        public void setStatue(String statue) {
            this.statue = statue;
        }
    }

    /**
     * 备忘录管理者
     */
    public class Caretaker {
        private Memento memento;

        public Caretaker(Memento memento) {
            this.memento = memento;
        }

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }
}
