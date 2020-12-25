package exercise.chapter1.section1;

import java.math.*;

import edu.princeton.cs.algs4.StdOut;

// 实现lg()函数
public class Exercise14_lg {
    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 2, 10, 32, 128};
        int[] expectd = new int[]{0, 0, 1, 3, 5, 7};
        for (int i = 0; i < input.length; i++) {
            int expct = expectd[i];
            int n1 = lg(input[i]);
            int n2 = mathLg(input[i]);
            if (n1 != expct || n1 != n2) {
                throw new RuntimeException("unexpected result of " + input[i]);
            }
        }
        StdOut.println("Passed");
    }

    // 返回不大于log2N的最大整数
    public static int lg(int n) {
        int c = 0;
        while (n > 1) {
            n /= 2;
            c++;
        }
        return c;
    }

    public static int mathLg(int n) {
        final double e = Math.log(2);
        double v = Math.log(n) / e;
        if (Double.isNaN(v) || Double.isInfinite(v)) {
            return 0;
        }
        return (int)(v);
    }
}
