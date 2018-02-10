package com.mu.zi.contentlib.p21_interpreter_pattern;

/**
 * 解释器模式
 * Created by y on 2018/1/23.
 */

public class InterpreterPatternScene {

    public abstract class Expression {
        //        public
        public abstract Object interpreter(Context ctx);

    }

    public class Context {

    }


    public class TerminalExpression extends Expression {
        @Override
        public Object interpreter(Context ctx) {
            return null;
        }
    }

    public class NonTerminalExpression extends Expression {
        @Override
        public Object interpreter(Context ctx) {
            return null;
        }
    }


}
