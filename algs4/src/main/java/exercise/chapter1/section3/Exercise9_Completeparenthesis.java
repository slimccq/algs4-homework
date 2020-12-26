package exercise.chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

// 补全左括号
public class Exercise9_Completeparenthesis
{
    public static void main(String[] args)
    {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 )))";
        if (args.length > 1) {
            input = args[1].trim();
        }
        String output = completeInfixExpr(input);
        StdOut.printf("input: %s\n", input);
        StdOut.printf("output: %s\n", output);
    }

    private static String[] operators = new String[]{"+","-","*","/"};

    public static int findOperator(String token) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(token)) {
                return i;
            }
        }
        return -1;
    }

    // 补全中缀表达式
    public static String completeInfixExpr(String input) {
        Stack<String> operandStk = new Stack<>();
        Stack<String> operatorStk = new Stack<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (token.equals("(")) {
                continue;
            }
            // 操作符压入栈中
            int i = findOperator(token);
            if (i >= 0) {
                operatorStk.push(token);
            } else {
                if (token.equals(")")) {
                    // 遇到右括号，弹出操作符和2个操作数，再作为子表达式压入操作符栈
                    String op = operatorStk.pop();
                    String rh = operandStk.pop();
                    String lh = operandStk.pop();
                    String subExpr = String.format("( %s %s %s )", lh, op, rh);
                    operandStk.push(subExpr);
                } else {
                    operandStk.push(token); // 压入操作数
                }
            }
        }
        return operandStk.pop();
    }
}