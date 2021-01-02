package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 3sum
public class Exercise2_ThreeSum {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N);
        int cnt = threeSum(arr);
        StdOut.printf("3sum %d\n", cnt);
    }

    // O(N^3)
    public static int threeSum(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    long sum = (long)a[i] + (long)a[j] + (long)a[k]; // 防止加法溢出
                    if (sum == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    // 先排序
    public static int threeSum2(int[] a)
    {
        Arrays.sort(a); // quick sort
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (BinarySearch.lessThanInt(a, -a[i]-a[j]) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 使用set查找
    public static int threeSum3(int[] a)
    {
        int N = a.length;
        int cnt = 0;
        Set<Integer> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (set.contains(-a[i]-a[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
