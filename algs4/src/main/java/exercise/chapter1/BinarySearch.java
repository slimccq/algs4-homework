package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

public class BinarySearch {

    public static int search(Comparable[] a, int lo, int hi, Comparable key) {
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

    public static int search(Comparable[] a, Comparable key) {
        return search(a, 0, a.length, key);
    }

    // 小于key的元素数量
    public static int lessThan(Comparable[] a, int lo, int hi, Comparable key) {
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

    public static int lessThan(Comparable[] a, Comparable key) {
        return lessThan(a, 0, a.length, key);
    }

    // 小于等于key的元素数量
    public static int lessEqual(Comparable[] a, int lo, int hi, Comparable key) {
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

    public static int lessEqual(Comparable[] a, Comparable key) {
        return lessEqual(a, 0, a.length, key);
    }

    // 等于key的元素数量
    public static int count(Comparable[] a, int lo, int hi, Comparable key) {
        int start = lessThan(a, lo, hi, key);
        if (start >= hi) {
            return 0;
        }
        int end = lessEqual(a, lo, hi, key);
        if (end >= hi) {
            return 0;
        }
        return end - start;
    }

    public static int count(Comparable[] a, Comparable key) {
        return count(a, 0, a.length, key);
    }

    public static int searchInt(int[] a, int lo, int hi, int key) {
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

    public static int searchInt(int[] a, int key) {
        return searchInt(a, 0, a.length, key);
    }

    // 返回小于该key的元素数量
    public static int lessThanInt(int[] a, int lo, int hi, int key) {
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

    public static int lessThanInt(int[] a, int key) {
        return lessThanInt(a, 0, a.length, key);
    }

    // 小于等于key的元素数量
    public static int lessEqualInt(int[] a, int lo, int hi, int key) {
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

    public static int lessEqualInt(int[] a, int key) {
        return lessEqualInt(a, 0, a.length, key);
    }

    // 等于key的元素数量
    public static int countInt(int[] a, int lo, int hi, int key) {
        int start = lessThanInt(a, lo, hi, key);
        if (start >= hi) {
            return 0;
        }
        int end = lessEqualInt(a, lo, hi, key);
        if (end >= hi) {
            return 0;
        }
        return end - start;
    }

    public static int countInt(int[] a, int key) {
        return countInt(a, 0, a.length, key);
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
