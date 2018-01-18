package com.mu.zi.contentlib.p15_composite_pattern;

import com.mu.zi.contentlib.p9_command_method.CommandScene;

import java.util.ArrayList;

/**
 * 组合模式
 * 构建树形结构，形成上下级结构，类似公司花名册。
 * <p>
 * Created by y on 2018/1/17.
 */

public class CompositePatternScene {


    public CompositePatternScene() {

        Composite root = new Composite();

        Composite branch1 = new Composite();
        branch1.setParent(root);
        branch1.addComponent(new Leaf());
        branch1.addComponent(new Leaf());
        branch1.addComponent(new Leaf());


        Composite branch2 = new Composite();
        branch2.setParent(root);
        branch2.addComponent(new Leaf());
        branch2.addComponent(new Leaf());
        branch2.addComponent(new Leaf());


        root.addComponent(branch1);
        root.addComponent(branch2);

        display(root);


    }

    private void display(Composite root) {

        for (Component component : root.componentList) {
            if (component instanceof Composite) {
                ((Composite) component).doSomething();
                display((Composite) component);
            } else {
                ((Leaf) component).doSomething();
            }

        }


    }


//    ------------------安全组合模式 start-----------------------------

    public interface Component {
        void doSomething();
    }

    /**
     * 树枝结构，级根节点和树枝节点的统一类
     */
    public class Composite implements Component {


        ArrayList<Component> componentList = new ArrayList<>();
        private Composite composite;

        /**
         * 添加子节点
         *
         * @param component
         */
        public void addComponent(Component component) {
            componentList.add(component);
        }

        /**
         * 移除子节点
         *
         * @param component
         */
        public void removeComponent(Component component) {
            componentList.remove(component);
        }

        /**
         * 设置parent
         * 方便从任意节点入手，获得根节点进行遍历
         *
         * @param composite
         */
        public void setParent(Composite composite) {
            this.composite = composite;
        }

        /**
         * 获得parent
         *
         * @return
         */
        public Composite getComposite() {
            return composite;
        }


        @Override
        public void doSomething() {
            System.out.println("Composite doSomething");

        }


    }

    /**
     * 树叶结构，没有下级，只有上级
     */
    public class Leaf implements Component {

        @Override
        public void doSomething() {
            System.out.println("Leaf doSomething");
        }
    }

//    ------------------安全组合模式  end-----------------------------




    //   ------------------透明组合模式 start-----------------------------

    /**
     * 定义了树枝和叶子结构的基本方法
     */
    public abstract class Crop implements Component {

        public abstract void addCrop(Crop crop);

        public abstract void removeCrop(Crop crop);

        public abstract ArrayList<Crop> getChild();

        public abstract void setParent(Crop crop);

        public abstract Crop getParent();


    }

    /**
     * 树枝、叶子统一类
     */
    public class Branch extends Crop {
        ArrayList<Crop> childList = new ArrayList<>();
        private Crop parent;

        @Override
        public void doSomething() {

        }

        @Override
        public void addCrop(Crop crop) {
            childList.add(crop);

        }

        @Override
        public void removeCrop(Crop crop) {
            childList.remove(crop);
        }


        /**
         * @return null==> 该结构为 树叶结构，反之则为树枝结构
         */
        @Override
        public ArrayList<Crop> getChild() {

            return (childList.size() == 0) ? null : childList;
        }

        @Override
        public void setParent(Crop crop) {
            parent = crop;
        }

        @Override
        public Crop getParent() {
            return parent;
        }
    }

//   ------------------透明组合模式 end-----------------------------


}
