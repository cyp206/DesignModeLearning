package com.mu.zi.contentlib.p21_interpreter_pattern;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * 一个 带加减法的表达式解析
 * 感觉做了一道汇编题，看了半天没看懂
 * Created by y on 2018/1/23.
 */

public class SubAndAddInterpreter {


    public SubAndAddInterpreter() {

        String expStr = getExpStr();
        HashMap<String, Integer> var = getValue(expStr);

        Calculator cal = new Calculator(expStr);

        System.out.println("结果：" + cal.run(var));


    }

    private HashMap<String, Integer> getValue(String expStr) {
        HashMap<String, Integer> map = new HashMap<>();
        Random random = new Random();
        for (char ch : expStr.toCharArray()) {

            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    String in = random.nextInt(50) + "";
                    System.out.println(String.valueOf(ch) + ":" + in);


                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }

        }

        return map;
    }

    public String getExpStr() {
        System.out.println("表达式：" + "a + b - c");

        return "a + b - c".replace(" ","");
    }

    public abstract class Expression {
        public abstract int interpreter(HashMap<String, Integer> var);

    }

    /**
     * 变量解析器
     */
    public class VarExpressiong extends Expression {

        private String key;

        public VarExpressiong(String _key) {
            this.key = _key;
        }


        @Override
        public int interpreter(HashMap<String, Integer> var) {
            return var.get(key);
        }
    }


    /**
     * 运算符号基础类
     */


    public class SymbolExpression extends Expression {

        Expression left;
        Expression right;

        public SymbolExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }


        @Override
        public int interpreter(HashMap<String, Integer> var) {
            return 0;
        }
    }


    public class SUbExpression extends SymbolExpression {


        public SUbExpression(Expression left, Expression right) {
            super(left, right);
        }

        @Override
        public int interpreter(HashMap<String, Integer> var) {
            return super.left.interpreter(var) - super.right.interpreter(var);
        }
    }

    public class AddExpression extends SymbolExpression {


        public AddExpression(Expression left, Expression right) {
            super(left, right);
        }

        @Override
        public int interpreter(HashMap<String, Integer> var) {
            return super.left.interpreter(var) + super.right.interpreter(var);
        }
    }


    public class Calculator {

        private Expression expression;

        public Calculator(String s) {
            Stack<Expression> stack = new Stack<>();
            char[] charArray = s.toCharArray();

            Expression left = null;
            Expression right = null;
            for (int i = 0; i < charArray.length; i++) {
                switch (charArray[i]) {

                    case '+':
                        left = stack.pop();
                        right = new VarExpressiong(String.valueOf(charArray[++i]));
                        stack.push(new AddExpression(left, right));
                        break;
                    case '-':
                        left = stack.pop();
                        right = new VarExpressiong(String.valueOf(charArray[++i]));
                        stack.push(new SUbExpression(left, right));
                        break;
                    default:
                        stack.push(new VarExpressiong(String.valueOf(charArray[i])));


                }

            }

            expression = stack.pop();


        }

        public int run(HashMap<String, Integer> var) {
            return expression.interpreter(var);
        }

    }


}
