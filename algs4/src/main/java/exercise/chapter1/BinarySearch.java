package exercise.chapter1;

import java.util.*;

import edu.princeton.cs.algs4.*;
import exercise.common.RandUtil;
import exercise.common.Utility;

public class BinarySearch {

    public static int search(Comparable[] a, Comparable key) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = a[mid].compareTo(key);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) { // a[mid] > key
                hi = mid;
            } else if (cmp < 0) { //(a[mid] < key)
                lo = mid + 1;
            }
        }
        return -1;
    }

    // 小于key的元素数量
    public static int lessThan(Comparable[] a, Comparable key) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = a[mid].compareTo(key);
            if (cmp >= 0) {
                hi = mid;
            } else if (cmp < 0) { // a[mid] < key)
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 小于等于key的元素数量
    public static int lessEqual(Comparable[] a, Comparable key) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = a[mid].compareTo(key);
            if (cmp <= 0) { // a[mid] <= key
                lo = mid + 1;
            } else if (cmp > 0) { // a[mid] > key
                hi = mid;
            }
        }
        return hi;
    }

    // 等于key的元素数量
    public static int count(Comparable[] a, Comparable key) {
        int lo = lessThan(a, key);
        if (lo >= a.length) {
            return 0;
        }
        int hi = lessEqual(a, key);
        if (hi >= a.length) {
            return 0;
        }
        return a.length - hi - lo;
    }

    public static int searchInt(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                hi = mid;
            } else if (a[mid] < key) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // 返回小于该key的元素数量
    public static int lessThanInt(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
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

    // 小于等于key的元素数量
    public static int lessEqualInt(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
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

    // 等于key的元素数量
    public static int countInt(int[] a, int key) {
        int start = lessThanInt(a, key);
        if (start >= a.length) {
            return 0;
        }
        int end = lessEqualInt(a, key);
        if (end >= a.length) {
            return 0;
        }
        return end - start;
    }


    public static void main(String args[]) {
        int N = 100;
        int[] arr = RandUtil.randIntArray(N);
        Arrays.sort(arr);
        StdOut.printf("array is: \n");
        Utility.printArray(arr);

        int target = RandUtil.randInt(N);
        int idx = searchInt(arr, target);
        StdOut.printf("search equal to %d, found at index %d\n", target, idx);
        int idx2 = lessThanInt(arr, target);
        StdOut.printf("search less than %d, found at index %d\n", target, idx2);
        int idx3 = lessEqualInt(arr, target);
        StdOut.printf("search less equal %d, found at index %d\n", target, idx3);
    }
}
