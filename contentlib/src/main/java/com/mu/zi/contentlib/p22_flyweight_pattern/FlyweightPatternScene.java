package com.mu.zi.contentlib.p22_flyweight_pattern;

import java.util.HashMap;

/**
 * 享元模式
 * Created by y on 2018/1/26.
 */

public class FlyweightPatternScene {

    public FlyweightPatternScene() {

        Flyweight test = FlyweightFactory.getFlyweight("test");

    }

    public static abstract class Flyweight {


        private String intrinsic;

        protected final String Extrinsic;


        public Flyweight(String _Extrinsic) {
            Extrinsic = _Extrinsic;
        }

        public String getIntrinsic() {
            return intrinsic;
        }

        public void setIntrinsic(String intrinsic) {
            this.intrinsic = intrinsic;
        }

        public abstract void operate();
    }


    public static class COncreteFlyweight1 extends Flyweight {

        public COncreteFlyweight1(String _Extrinsic) {
            super(_Extrinsic);
        }

        @Override
        public void operate() {

        }
    }


    public static class FlyweightFactory {

        private static HashMap<String, Flyweight> pool = new HashMap<>();

        public static Flyweight getFlyweight(String Extrinic) {
            if (pool.containsKey(Extrinic)) {
                return pool.get(Extrinic);
            } else {
                Flyweight flyweight = new COncreteFlyweight1(Extrinic);
                pool.put(Extrinic, flyweight);
                return flyweight;
            }

        }
    }

}
