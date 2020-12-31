package exercise.chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

// 后缀表达式求值
public class Exercise11_Postfix {
    public static String[] operators = new String[]{"+", "-", "*", "/"};
    public static int[] precedence = new int[]{1, 1, 2, 2, 3}; //操作符优先级

    public static void main(String[] args) {
        String input = "3 + 4 + 2 * 3 * 6 - 4 * 2";
        //input = "( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )";
        //input = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        if (args.length > 1) {
            input = args[1];
        }
        StdOut.printf("input: %s\n", input);
        String expr = Exercise10_Infix.infixToPostfixWithPrecedence(input);
        StdOut.printf("postfix expr: %s\n", expr);
        long output = evaluatePostfix(expr);
        StdOut.printf("output: %d\n", output);
    }

    //
    private static long evaluatePostfix(String expr) {
        Stack<Long> stack = new Stack<>();
        Scanner scanner = new Scanner(expr);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isOperator(token)) {
                long right = stack.pop();
                long left = stack.pop();
                long n = evaluate(token, left, right);
                stack.push(n);
            } else {
                // 若是操作数直接入栈
                stack.push(Long.parseLong(token));
            }
        }
        return stack.pop();
    }

    private static long evaluate(String operator, long n1, long n2) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
        }
        return 0;
    }

    private static boolean isOperator(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return true;
            }
        }
        return false;
    }
}