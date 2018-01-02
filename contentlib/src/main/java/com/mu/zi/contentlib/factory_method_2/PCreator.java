package com.mu.zi.contentlib.factory_method_2;

/**
 * 产品制造工厂
 * Created by y on 2018/1/2.
 */

public class PCreator extends Creator {
    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> tClass) {
        AbstractProduct product = null;
        try {
            product = (T) Class.forName(tClass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) product;
    }
}
