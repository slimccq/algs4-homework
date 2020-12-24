package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

// 整数转换为二进制
public class Exercise9 {
    public static void main(String[] args) {
        int n = 32;
        if (args.length > 1) {
            n = Integer.parseInt(args[1]);
        }
        String s = toBinaryString(n);
        StdOut.printf("%d to binary: 0b%s\n", n, s);
    }

    public static String toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n%2);
            n /= 2;
        }
        return sb.toString();
    }
}