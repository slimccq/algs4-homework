package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

// 递归计算lg(N!)
public class Exercise20 {
    public static void main(String[] args)
    {
        long N = 20;
        if (args.length > 1) {
            N = Long.parseLong(args[1]);
        }
        long r = lg(fact(N));
        StdOut.printf("lg(N!) of %d is %d\n", N, r);
    }

    // 计算阶乘N!
    public static long fact(long n)
    {
       if (n == 0 || n == 1)
           return 1;
       return n * fact(n-1);
    }

    public static long lg(long n) {
        long c = 0;
        while (n > 1) {
            n /= 2;
            c++;
        }
        return c;
    }
}
