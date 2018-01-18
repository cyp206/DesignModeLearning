package com.mu.zi.contentlib.p9_command_method;

/**
 * 命令模式
 * Created by y on 2018/1/11.
 */

public class CommandScene {

    /**
     * 接收者抽象类
     */
    public abstract class Receiver {
        //抽象接收者，定义每个接收者都必须完成的业务
        public abstract void doSomething();


    }


    /**
     * 接收者实现类，可以定义一些接收者的功能
     */
    public class ConcreteReceiver1 extends Receiver {


        public ConcreteReceiver1() {
        }


        @Override
        public void doSomething() {

        }
    }


    public abstract class Command {
        //每个命令类都必须有一个执行命令的方法
        public abstract void excute();
    }


    /**
     * 命令封装具体类
     * 根据任务集合将接收者已经任务安排好
     */
    public class ConcreteCommand1 extends Command {
        private Receiver receiver;

        public ConcreteCommand1(Receiver receiver) {
            this.receiver = receiver;

        }

        @Override
        public void excute() {
            this.receiver.doSomething();
        }
    }

    public class ConcreteCommand2 extends Command {
        private Receiver receiver;

        public ConcreteCommand2(Receiver receiver) {
            this.receiver = receiver;

        }

        @Override
        public void excute() {
            this.receiver.doSomething();
        }
    }

    /**
     * 统筹者，直接执行之前已经安排好的任务。
     */
    public class Invoker {
        private Command command;

        public void setCommand(Command _command) {
            command = _command;
        }

        public void action() {
            this.command.excute();
        }

    }


    public CommandScene() {

        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.action();

    }


}
