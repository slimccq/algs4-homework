package exercise.chapter1.section4;


import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 二分查找
public class Exercise10_BinSearch
{
    public static void main(String[] args) {
        int N = 20;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        StdOut.printf("array: \n");
        Integer[] a = RandUtil.randIntegerArray(N);
        Arrays.sort(a);
        Utility.printArray(a);

        int target = RandUtil.randInt(N);
        int i = binarySearch(a, target);
        StdOut.printf("find %d at %d\n", target, i);
    }

    public static int binarySearch(Comparable[] arr, Comparable target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = target.compareTo(arr[mid]);
            if (cmp > 0) { // target > arr[mid]
                lo = mid + 1;
            } else if (cmp < 0) {

            } else {
                return mid;
            }
        }
        return lo;
    }
}