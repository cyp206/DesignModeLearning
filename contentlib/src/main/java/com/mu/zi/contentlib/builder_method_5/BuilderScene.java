package com.mu.zi.contentlib.builder_method_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by y on 2018/1/5.
 */

public class BuilderScene {


    public BuilderScene() {
        Director director = new Director();
    }


    class Product {

        List<String> list = new ArrayList<>();


        public void add(String part) {
            list.add(part);
        }


        public void show() {

            for (String part : list) {
                System.out.println(part);
            }
        }
    }


    public abstract class Builder {

        public abstract Builder builderA();

        public abstract Builder builderB();

        public abstract Product getProduct();


    }


    public class BuilderA extends Builder {

        public Product product = new Product();

        @Override
        public BuilderA builderA() {
            product.add("apart a ");
            return this;
        }

        @Override
        public BuilderA builderB() {
            product.add("apart b ");
            return this;
        }

        @Override
        public Product getProduct() {
            return product;
        }


    }


    public class Director {
        public Director() {
            Product p1 = new BuilderA()
                    .builderA()
                    .builderB()
                    .builderA()
                    .getProduct();

            p1.show();
        }


    }


}
