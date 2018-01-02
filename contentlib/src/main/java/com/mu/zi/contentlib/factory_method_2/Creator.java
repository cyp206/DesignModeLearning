package com.mu.zi.contentlib.factory_method_2;

/**
 * Created by y on 2018/1/2.
 */

public abstract class Creator {

    public abstract <T extends AbstractProduct> T createProduct(Class<T> tClass);
}
