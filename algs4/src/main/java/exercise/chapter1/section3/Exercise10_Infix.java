package exercise.chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 中缀表达式转换为后缀表达式
public class Exercise10_Infix {
    private static final String[] leftOps = new String[]{"(", "[", "{"};
    private static final String[] rightOps = new String[]{")", "]", "}"};
    public static final String[] operators = new String[]{"+", "-", "*", "/"};
    public static final int[] precedence = new int[]{1, 1, 2, 2}; //操作符优先级

    public static void main(String[] args) {
        String input = "3 + 4 + 2 * 3 * 6 - 4 * 2";
        //input = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        //input = "( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )";
        //input = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        if (args.length > 1) {
            input = args[1];
        }
        String output1 = infixToPostfixSimple(input);
        String output2 = infixToPostfixWithPrecedence(input);
        StdOut.printf("input: %s\n", input);
        StdOut.printf("output1: %s\n", output1);
        StdOut.printf("output2: %s\n", output2);
    }

    // 中缀表达式转换为后缀表达式(判断了操作符优先级)
    public static String infixToPostfixWithPrecedence(String input) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String token = scanner.next();
            int i = findSymbol(leftOps, token);
            if (i >= 0) {
                stack.push(token);
                continue;
            }
            // 遇到右括号将栈弹出，直至遇到左括号
            i = findSymbol(rightOps, token);
            if (i >= 0) {
                while (!stack.isEmpty()) {
                    String operator = stack.pop();
                    if (operator.equals(leftOps[i])) {
                        break;
                    }
                    result.add(operator);
                }
            }
            else if (isOperator(token)) {
                // If the precedence order of the scanned(incoming) operator is greater than
                // the precedence order of the operator in the stack (or the stack is empty or
                // the stack contains a ‘(‘ or ‘[‘ or ‘{‘), push it on stack.
                // Else, Pop all the operators from the stack which are greater than or equal to
                // in precedence than that of the scanned operator.
                // After doing that Push the scanned operator to the stack.
                while (!stack.isEmpty()) {
                    if (getPrecedence(stack.peek()) >= getPrecedence(token)) {
                        result.add(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(token);
            } else {
                result.add(token); // operand
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return String.join(" ", result);
    }

    public static String infixToPostfixSimple(String input) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isOperator(token)) {
                stack.push(token);
                continue;
            }
            if (token.equals(")")) {
                result.add(stack.pop());
            } else if (token.equals("(")) {
                // nothing
            } else {
                result.add(token);
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return String.join(" ", result);
    }

    // 获取操作符优先级
    private static int getPrecedence(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return precedence[i];
            }
        }
        return -1;
    }

    private static boolean isOperator(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return true;
            }
        }
        return false;
    }

    private static int findSymbol(String[] symbols, String token) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].equals(token)) {
                return i;
            }
        }
        return -1;
    }
}