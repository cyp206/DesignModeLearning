package com.mu.zi.contentlib.p18_memento_pattern;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 多属性情况下的备忘录模式
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by y on 2018/1/20.
 */

public class MementoPatternForProperties {

    public MementoPatternForProperties() {

        Originator originator = new Originator();
        originator.setName("seven myself");
        originator.setAge(7);
        originator.getList().add("hia ..hia");
        originator.print();
        System.out.println("------------------" + "backup  ----------------");

        CareTaker careTaker = new CareTaker();
        originator.createMemento();
        careTaker.setProperties(originator.createMemento());
        originator.setName("jdslfsjdfjlsdjflsd");
        originator.setAge(7324);
        originator.getList().add("hia .fsdfsd.hia");
        originator.print();

        originator.restore(careTaker.getProperties());

        System.out.println("------------------" + "restore  ----------------");

        originator.print();

    }

    public class Originator {

        private String name;
        private int age;
        List<String> list = new ArrayList<>();


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }


        public HashMap<String, Object> createMemento() {

            return new BeanUtils().backupProp(this);
        }


        public void restore(HashMap<String, Object> list) {
            new BeanUtils().resotre(this, list);
        }


        public void print() {
            System.out.println("name: " + name);
            System.out.println("age: " + age);
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s + "__");
            }
            System.out.println("list: " + builder);


        }

    }


    public class BeanUtils {

        /**
         * 通过解析class，存储属性和属性值于hashmap中，便于还原。
         * 注意：
         * 1、调用getReadMethod 会根据get关键字去遍历bean这个class 的所有方法，所以，尽量进行方法过滤，可能会出现死循环。
         * eg：createMemento这个方法一开始是写成 getMemento 在方法遍历的时候，出现了递归，然后就是死循环。
         * 2、关于非原始数据类型的问题，类似之前原型模式出想的问题，浅拷贝和深考虑的问题。所以针对非原始数据类型，需要存储的方法是它的clone 类。
         *
         * @param bean
         * @return
         */
        public HashMap<String, Object> backupProp(Object bean) {

            HashMap<String, Object> properties = new HashMap<>();
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                //属性描述list
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor des : propertyDescriptors) {
                    String name = des.getName();
                    //获得get 方法
                    Method getter = des.getReadMethod();

                    if (!name.equalsIgnoreCase("class")) {
                        i("name==>" + getter.getName());
                        Object invoke = getter.invoke(bean, new Object[]{});
                        if (invoke instanceof ArrayList) {
                            properties.put(name, ((ArrayList) invoke).clone());

                        } else {
                            properties.put(name, invoke);

                        }
                    }
                }

            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            return properties;
        }

        public void resotre(Object bean, HashMap<String, Object> list) {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor des : propertyDescriptors) {
                    String name = des.getName();
                    //获得set 方法
                    Method writeMethod = des.getWriteMethod();
                    if (list.containsKey(name)) {
                        writeMethod.invoke(bean, new Object[]{list.get(name)});
                    }

                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public class CareTaker {
        HashMap<String, Object> properties;

        public CareTaker() {
        }

        public HashMap<String, Object> getProperties() {
            return properties;
        }

        public void setProperties(HashMap<String, Object> properties) {
            this.properties = properties;
        }
    }


    public void i(String s) {
        System.out.println(s);
    }

}
