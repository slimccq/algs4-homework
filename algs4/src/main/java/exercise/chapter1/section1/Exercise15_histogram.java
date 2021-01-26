package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;

import java.util.HashMap;
import java.util.HashSet;

// histogram
public class Exercise15_histogram {
    public static void main(String[] args) {
        int N = 100;
        int M = 100;
        if (args.length > 2) {
            N = Integer.parseInt(args[1]);
            M = Integer.parseInt(args[2]);
        }
        //int[] a = RandUtil.randIntArray(N);
        int[] a = {
                97, 65, 81, 40, 29, 40, 29, 30, 40, 6,
                31, 96, 71, 42, 95, 15, 74, 32, 48, 21,
                39, 48, 57, 94, 74, 13, 56, 36, 14, 99,
                56, 65, 49, 22, 32, 7, 8, 3, 46, 30, 18,
                33, 18, 82, 51, 85, 20, 3, 33, 90, 37,
                64, 67, 68, 35, 53, 75, 50, 67, 82, 70,
                83, 25, 62, 93, 82, 67, 81, 27, 53, 15,
                92, 2, 80, 38, 79, 88, 48, 86, 9, 32,
                46, 84, 73, 69, 46, 71, 97, 35, 16, 50,
                35, 92, 30, 24, 45, 59, 62, 96, 5, 0, 0,
        };
        int[] m = histogram(a, M);
        int total = 0;
        for (int i = 0; i < M; i++) {
            total += m[i];
            StdOut.printf("%d %d\n", i, m[i]);
        }
        StdOut.printf("total: %d\n", total);
    }

    // 其中第 i 个元素的值为整数 i 在参数数组中出现的次数
    public static int[] histogram(int[] a, int M) {
        int[] r = new int[M];
        for (int i = 0; i < M; i++) {
            if (a[i] < M) {
                r[a[i]]++;
            }
        }
        return r;
    }
}
