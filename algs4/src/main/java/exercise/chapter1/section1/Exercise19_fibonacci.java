package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

// 计算Fibonacci
public class Exercise19_fibonacci {
    public static void main(String[] args) {
        int n = 50;
        int method = 3;
        if (args.length > 1) {
            n = Integer.parseInt(args[1]);
            if (args.length > 2) {
                method = Integer.parseInt(args[2]);
            }
        }
        StdOut.printf("start calc fib %d using method %d\n", n, method);
        long r = 0;
        long startAt = System.currentTimeMillis();
        switch (method) {
            case 1:
                r = fib_slow(n);
                break;
            case 2:
                r = fib_dp(n);
                break;
            case 3:
                r = fib_fast(n);
                break;
        }
        long costTime = System.currentTimeMillis() - startAt;
        StdOut.printf("fib %d is %d, cost %dms\n", n, r, costTime);
    }

    // 最朴素的算法
    public static long fib_slow(long n) {
        if (n == 1 || n == 2)
            return 1;
        return fib_slow(n - 1) + fib_slow(n - 2);
    }

    // 使用临时数组
    public static long fib_dp(int n) {
        long[] arr = new long[n + 1];
        return fib_dp_helper(arr, n);
    }

    public static long fib_dp_helper(long[] a, int n) {
        if (n == 1 || n == 2)
            return 1;
        if (a[n] == 0) {
            long n1 = fib_dp_helper(a, n - 1);
            long n2 = fib_dp_helper(a, n - 2);
            a[n] = n1 + n2;
        }
        return a[n];
    }

    // 使用临时变量
    public static long fib_fast(int n) {
        if (n == 1 || n == 2)
            return 1;
        long n1 = 1;
        long n2 = 1;
        for (int i = 0; i < n; i++) {
            long sum = n1 + n2;
            n2 = n1;
            n1 = sum;
        }
        return n1;
    }
}
