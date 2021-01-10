package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.HashSet;
import java.util.Set;

// 快速3sum
public class Exercise15_fast3sum {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N);
        Utility.printArray(arr);
        int cnt = fast3Sum(arr);
        StdOut.printf("3sum: %d\n", cnt);
    }

    public static int fast2sum(int[] a) {
        int N = a.length;
        int cnt = 0;
        Set<Integer> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < N; i++) {
            if (set.contains(-a[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    // 使用set查找
    public static int fast3Sum(int[] a) {
        int N = a.length;
        int cnt = 0;
        Set<Integer> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (set.contains(-a[i] - a[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
