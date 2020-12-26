package exercise.chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

// 后缀表达式求值
public class Exercise11_Postfix {
    public static String[] operators = new String[]{"+", "-", "*", "/", "^"};
    public static int[] precedence = new int[]{1, 1, 2, 2, 3}; //操作符优先级

    public static void main(String[] args) {
        String input = "6 * ( 5 + ( 2 + 3 ) * 8 ) + 3";
        if (args.length > 1) {
            input = args[1];
        }
        StdOut.printf("input: %s\n", input);
        String expr = Exercise10_Infix.infixExprToPostfix(input);
        StdOut.printf("postfix expr: %s\n", expr);
        long output = evaluatePostfix(expr);
        StdOut.printf("output: %d\n", output);
    }

    //
    public static long evaluatePostfix(String expr) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(expr);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isOperator(token)) {
                String lhs = stack.pop();
                String rhs = stack.pop();
                long n = evaluate(token, lhs, rhs);
                stack.push(n + "");
            } else {
                // 若是操作数直接入栈
                stack.push(token);
            }
        }
        String top = stack.pop();
        return Long.parseLong(top);
    }

    public static long evaluate(String operator, String left, String right) {
        long n1 = Long.parseLong(left);
        long n2 = Long.parseLong(right);
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            case "^":
                return (long) Math.pow(n1, n2);
        }
        return 0;
    }

    public static boolean isOperator(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return true;
            }
        }
        return false;
    }
}