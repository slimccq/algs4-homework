package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

// 打印欧几里得深度
public class Exercise24 {

    public static void main(String[] args)
    {
        int p = 105;
        int q = 24;
        if (args.length > 2) {
            p = Integer.parseInt(args[1]);
            q = Integer.parseInt(args[2]);
        }
        euclidGcd(p, q);
    }

    // prove https://www.whitman.edu/mathematics/higher_math_online/section03.03.html
    public static int euclidGcd(int p, int q)
    {
        while(q > 0) {
            StdOut.printf("p = %d, q = %d\n", p, q);
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }
}
