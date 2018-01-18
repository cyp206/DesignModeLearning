package com.mu.zi.contentlib.p2_factory_method;

/**
 * Created by y on 2018/1/2.
 */

public abstract class Creator {

    public abstract <T extends AbstractProduct> T createProduct(Class<T> tClass);
}
