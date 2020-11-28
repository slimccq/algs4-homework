package com.example.chapter2;

import edu.princeton.cs.algs4.*;


// 插入排序
public class Insertion extends SortBase
{
    // Exercise 2.1.26 原始int类型版本
    public static void sortInt(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = i; j > 0 && arr[j] > arr[j-1]; j--)
            {
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }
    public static void sort(Comparable[] arr)
    {
        binarySort(arr, 0, arr.length - 1);
    }

    // Exercise 2.1.25 将大于待插入的数右移
    public static void sort1(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int j = i - 1;
            Comparable curr = arr[i];
            while (j >= 0 && arr[j].compareTo(curr) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }


    // Exercise 2.1.24 哨兵，去掉内循环中j>0的判断
    public static void sort2(Comparable[] arr)
    {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[min]) < 0) {
                min = i;
            }
        }
        if (min != 0) {
            exch(arr, min, 0);
        }
        for (int i = 2; i < arr.length; i++)
        {
            for (int j = i; less(arr, j, j-1); j--)
            {
                exch(arr, j, j-1);
            }
        }
    }

    // 小于等于key的index，查找[lo, hi), 返回[lo, hi]
    public static int binarySearch(Comparable[] arr, int lo, int hi, Comparable key)
    {
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = arr[mid].compareTo(key);
            // arr[mid] <= key
            if (cmp <= 0) {
                lo = mid + 1;
            }
            else if (cmp > 0) {
                hi = mid;
            }
        }
        return hi;
    }

    public static void binarySort(Comparable[] arr)
    {
        binarySort(arr, 0, arr.length - 1);
    }

    // 代入二分查找的插入排序, [lo, hi]
    public static void binarySort(Comparable[] arr, int lo, int hi)
    {
        for (int i = lo+1; i <= hi; i++)
        {
            int idx = binarySearch(arr, lo, i, arr[i]);
            if (idx != i)
            {
                Comparable tmp = arr[i];
                int j = i - 1;
                for (; j >= idx; j--) {
                    arr[j+1] = arr[j];
                }
                arr[idx] = tmp;
            }
        }
    }

    // 递归版本
    public static void RecursiveSort(Comparable[] arr, int n)
    {
        // base case
        if (n <= 1)
            return ;

        // sort first n-1 elements
        RecursiveSort(arr, n-1);

        // insert last element to sorted array
        Comparable last = arr[n-1];
        int j = n - 2;
        while (j >= 0 && less(last, arr[j])) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }

    public static double benchmarkSort(int N, int T, int method)
    {
        double total = 0.0;
        Integer[] arr = new Integer[N];
        for (int t = 0; t < T; t++)
        {
            for (int i = 0; i < N; i++) {
                arr[i] = StdRandom.uniform(1000);
            }
            Stopwatch timer = new Stopwatch();
            if (method == 1) {
                Insertion.sort1(arr);
            } else if (method == 2) {
                Insertion.sort2(arr);
            } else if (method == 3) {
                Insertion.binarySort(arr);
            }
            total += timer.elapsedTime();
            if (!SortUtil.isSorted(arr)) {
                throw new RuntimeException("array is not sorted " + method);
            }
        }
        return total;
    }

    public static void showBenchmarks(int N, int T)
    {
        double t1 = benchmarkSort(N, T, 1);
        double t2 = benchmarkSort(N, T, 2);
        double t3 = benchmarkSort(N, T, 3);
        StdOut.printf("direct insertion sort: %.2f\n", t1);
        StdOut.printf("sentinal insertion sort: %.2f\n", t2);
        StdOut.printf("binsearch insertion sort: %.2f\n", t3);
    }

    public static void main(String[] args)
    {
        int N = 1000;
        int T = 100;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                T = Integer.parseInt(args[1]);
            }
        }
        showBenchmarks(N, T);
    }
}