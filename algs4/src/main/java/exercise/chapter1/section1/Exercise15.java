package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;

import java.util.HashMap;
import java.util.HashSet;

// histogram
public class Exercise15 {
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
            // r[i] = findOccurNum(a, i);
            // r[i] = findOccurNum2(a, i);
            // r[i] = findOccurNum3(a, i);
        }
        return r;
    }

    // n在a中出现的次数, O(N*N)
    public static int findOccurNum(int[] a, int n) {
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                c++;
            }
        }
        return c;
    }

    // 使用hash表记录次数, O(N)空间，O(1)查找
    private static HashMap<Integer, Integer> dict = new HashMap<>();

    public static int findOccurNum2(int[] a, int n) {
        if (dict.size() == 0) {
            for (int i = 0; i < a.length; i++) {
                int exist = dict.getOrDefault(a[i], 0);
                dict.put(a[i], exist + 1);
            }
        }
        return dict.getOrDefault(n, 0);
    }

    // 排序后使用二分查找, O(N*lg(N))
    private static boolean isSorted = false;

    public static int findOccurNum3(int[] a, int n) {
        if (!isSorted) {
            insertionSort(a);
            isSorted = true;
        }
        int lo = lower_bound(a, n);
        int hi = upper_bound(a, n);
        return hi - lo;
    }

    // 插入排序
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }

    // 返回小于该key的元素数量
    public static int lower_bound(int[] sorted, int key) {
        int lo = 0;
        int hi = sorted.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] >= key) {
                hi = mid;
            } else if (sorted[mid] < key) {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 小于等于key的数量
    public static int upper_bound(int[] sorted, int key) {
        int lo = 0;
        int hi = sorted.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] <= key) {
                lo = mid + 1;
            } else if (sorted[mid] > key) {
                hi = mid;
            }
        }
        return hi;
    }
}
