package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 二分查找rank和count
public class Exercise29_binSearchCount {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N, N*80/100);
        int target = arr[RandUtil.randInt(N)];

        Arrays.sort(arr);
        Utility.printArray(arr);
        int[] where = new int[2];
        int cnt = count(arr, target, where);
        StdOut.printf("found #%d of %d at [%d-%d]\n", cnt, target, where[0], where[1]);
    }

    // 返回小于等于key的索引，即小于该key的元素数量
    public static int rank(int[] a, int lo, int hi, int key) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= key) {
                hi = mid;
            } else if (a[mid] < key) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 返回第一个大于key的元素索引
    public static int upper(int[] a, int lo, int hi, int key) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid;
            }
        }
        return hi;
    }

    public static int count(int[] a, int key, int[] where) {
        int lo = rank(a, 0, a.length, key);
        if (lo >= a.length) {
            return 0;
        }
        int hi = upper(a, lo, a.length, key);
        if (hi >= a.length) {
            return 0;
        }
        int n = hi - lo;
        if (n > 0) {
            where[0] = lo;
            where[1] = hi - 1;
        }
        return n;
    }
}
