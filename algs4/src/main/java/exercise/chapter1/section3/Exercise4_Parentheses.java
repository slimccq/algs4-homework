package exercise.chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


// 括号是否配对匹配
public class Exercise4_Parentheses {

    private static char[] leftOps = new char[]{'[', '(', '{'};
    private static char[] rightOps = new char[]{']', ')', '}'};

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            // s = "[()]{}{[()()]()}";
            boolean ok = isBalancedParentheses(s);
            StdOut.printf("parenthesis %s balanced\n", ok ? "is" : "is not");
        }
    }

    private static int findSymbol(char[] symbols, char ch) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isBalancedParentheses(String input) {
        Stack stk = new Stack();
        boolean ok = true;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int idx = findSymbol(leftOps, ch);
            if (idx >= 0) // 如果是开放符号，则压栈
            {
                stk.push(ch);
                continue;
            }
            idx = findSymbol(rightOps, ch);
            if (idx >= 0) { // 如果是封闭符号
                if (stk.isEmpty()) { //栈为空则符号不匹配
                    ok = false;
                    break;
                } else {
                    char last = (char) stk.pop(); // 判断弹出的符号是不是对应的开放符号
                    int open = leftOps[idx];
                    if (last != open) {
                        ok = false;
                        break;
                    }
                }
            }
        }
        //扫描完，如果栈非空，则符号不匹配
        if (!stk.isEmpty()) {
            ok = false;
        }
        return ok;
    }

}