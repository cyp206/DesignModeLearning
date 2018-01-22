package com.mu.zi.contentlib.p20_State_pattern;

/**
 * Created by y on 2018/1/22.
 */

public class StatePatternScene {

    public StatePatternScene() {

        Context context = new Context();
        context.setCurrentState(new Handle1State());
        context.handle2();
        context.handle1();

    }


    public class Context {

        public final State handle2State = new Handle1State();
        public final State handle1State = new Handle2State();
        private State currentState;

        public State getCurrentState() {
            return currentState;
        }

        public void setCurrentState(State currentState) {
            this.currentState = currentState;
            this.currentState.setContext(this);
        }


        public void handle1() {

            currentState.handle1();

        }

        public void handle2() {
            currentState.handle2();

        }
    }

    /**
     * 状态类的抽象类
     * 记住状态的两个职责
     * 1、行为操作
     * 2、状态过度
     */
    public abstract class State {

        private Context context;

        public State() {

        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        /**
         * 行为1
         */
        public abstract void handle1();


        /**
         * 行为2
         */
        public abstract void handle2();

    }


    public class Handle1State extends State {

        @Override
        public void handle1() {
            System.out.println("do nothing ,it is  handle1");
        }

        @Override
        public void handle2() {
            System.out.println("do handle2");
            getContext().setCurrentState(getContext().handle2State);
        }
    }

    public class Handle2State extends State {

        @Override
        public void handle1() {
            System.out.println("do handle1");
            getContext().setCurrentState(getContext().handle1State);
        }

        @Override
        public void handle2() {
            System.out.println("do nothing ,it is  handle2");


        }
    }


}
