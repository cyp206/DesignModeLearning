package com.mu.zi.contentlib.factory_method_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y on 2018/1/2.
 */

public class SingleCollegeCreator {

    private static Map<String, AbstractProduct> map = new HashMap<>();

    public static <T extends AbstractProduct> T createProduct(Class<T> tClass) {
        T t = null;
        try {
            t = (T) Class.forName(tClass.getName()).newInstance();
            map.put(tClass.getName(), t);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }


    public static <T extends AbstractProduct> T getInstance(Class<T> tClass) {
        AbstractProduct product = null;
        if (map.containsKey(tClass.getName())) {
            product = map.get(tClass.getName());
        } else {
            product = createProduct(tClass);
        }
        return (T) product;

    }

}
