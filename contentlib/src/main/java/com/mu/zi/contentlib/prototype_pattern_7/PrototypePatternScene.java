package com.mu.zi.contentlib.prototype_pattern_7;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 * <p>
 * 验证：
 * 1、浅克隆 和 深克隆
 * 2、 final 无法实现深克隆
 * 3、克隆的时候，构造方法将不会被调用
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by y on 2018/1/9.
 */

public class PrototypePatternScene {

    public PrototypePatternScene() {
        System.out.println("------------------浅克隆-----------------------");
        getPrototype(false);
        System.out.println("------------------深克隆-----------------------");
        getPrototype(true);


    }

    private Prototype getPrototype(boolean isDeep) {
        Prototype prototype = new Prototype();
        prototype.add("a1");
        prototype.addFinal("a1");
        prototype.setDeep(isDeep);
        Prototype clone = null;
        try {
            clone = prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.addFinal("a2");
        clone.add("a2");
        System.out.println("原型");
        prototype.getString();
        System.out.println("克隆");
        clone.getString();
        return prototype;
    }


    /**
     * 浅克隆
     */
    public class Prototype implements Cloneable {


        private String mName;
        private int mLevel;
        private List<String> list;
        private final List<String> finalList = new ArrayList<>();

        private boolean isDeep;

        public Prototype() {
            System.out.println("Prototype() ");
            mName = "default name";
            mLevel = -1;
            list = new ArrayList<>();


        }


        public Prototype(String name, int level) {
            System.out.println("Prototype(String name, int level)");

            mName = name;
            mLevel = level;
            list = new ArrayList<>();

        }

        /**
         * 通过重写clone方法实现克隆
         *
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Prototype clone() throws CloneNotSupportedException {
            Prototype clone = (Prototype) super.clone();
            if (isDeep) {
                clone.list = (List<String>) ((ArrayList<String>) this.list).clone();
            }

            return clone;

        }


        public void getString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : list) {
                stringBuilder.append(s);
            }
            System.out.println("list ==>" + stringBuilder.toString());
            stringBuilder.replace(0, stringBuilder.length(), "");
            for (String s : finalList) {
                stringBuilder.append(s);
            }
            System.out.println("finalList ==>" + stringBuilder.toString());
        }


        public void add(String arg) {
            list.add(arg);
        }

        public void addFinal(String arg) {
            finalList.add(arg);
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public int getmLevel() {
            return mLevel;
        }

        public void setmLevel(int mLevel) {
            this.mLevel = mLevel;
        }


        public boolean isDeep() {
            return isDeep;
        }

        public void setDeep(boolean deep) {
            isDeep = deep;
        }
    }


}
