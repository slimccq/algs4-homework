package exercise.chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 中缀表达式转换为后缀表达式
public class Exercise10_Infix {
    public static String[] operators = new String[]{"+", "-", "*", "/", "^"};
    public static int[] precedence = new int[]{1, 1, 2, 2, 3}; //操作符优先级

    public static void main(String[] args) {
        String input = "a + b * c + ( d * e + f ) * g";
        if (args.length > 1) {
            input = args[1];
        }
        String output = infixExprToPostfix(input);
        StdOut.printf("input: %s\n", input);
        StdOut.printf("output: %s\n", output);
    }

    // 获取操作符优先级
    public static int getOperatorPrecedence(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return precedence[i];
            }
        }
        return -1;
    }

    // 中缀表达式转换为后缀表达式
    public static String infixExprToPostfix(String input) {
        List tokens = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (token.equals("(")) {
                stack.push(token);
                continue;
            }
            // 遇到右括号将栈弹出，直至弹出对应的左括号
            if (token.equals(")")) {
                while (!stack.isEmpty()) {
                    String operator = stack.pop();
                    if (operator.equals("(")) {
                        break;
                    }
                    tokens.add(operator);
                }
                continue;
            }
            // 是操作符入栈，先弹出比自己优先级高的操作符
            int pre1 = getOperatorPrecedence(token);
            if (pre1 >= 0) {
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    int pre2 = getOperatorPrecedence(top);
                    if (pre2 >= pre1) {
                        stack.pop();
                        tokens.add(top);
                    } else {
                        break;
                    }
                }
                stack.push(token);
            } else {
                tokens.add(token);
            }
        }
        while (!stack.isEmpty()) {
            String token = stack.pop();
            tokens.add(token);
        }
        return String.join(" ", tokens);
    }
}