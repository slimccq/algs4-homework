package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 二分查找rank和count
public class Exercise29_binSearchCount {
    public static void main(String[] args)
    {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int target = RandUtil.randInt(N);
        int[] arr = RandUtil.randIntArray(N);
        arr[N-1] = 100;

        Arrays.sort(arr);
        Utility.printArray(arr);
        int[] where = new int[2];
        int cnt = count(arr, target, where);
        StdOut.printf("found #%d of %d at [%d-%d]\n", cnt, target, where[0], where[1]);
    }

    // 返回小于该key的元素数量
    public static int rank(int[] a, int key)
    {
        int lo = 0;
        int hi = a.length;
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= key) {
                hi = mid;
            }
            else if (a[mid] < key) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 小于等于key的元素数量
    public static int upper(int[] a, int key)
    {
        int lo = 0;
        int hi = a.length;
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= key) {
                lo = mid + 1;
            }
            else if (a[mid] > key) {
                hi = mid;
            }
        }
        return hi;
    }

    public static int count(int[] a, int key, int[] where)
    {
        int lo = rank(a, key);
        if (lo >= a.length) {
            return 0;
        }
        int hi = upper(a, key);
        if (hi >= a.length) {
            return 0;
        }
        int n = hi - lo;
        if ( n > 0) {
            where[0] = lo;
            where[1] = hi - 1;
        }
        return n;
    }
}
