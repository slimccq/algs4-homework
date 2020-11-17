package com.example.chapter2;

import edu.princeton.cs.algs4.StdRandom;

// 快速排序
public class Quick
{
    public static void sort(Comparable[] arr)
    {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static int partition(Comparable[] arr, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable v = arr[lo];
        while(true)
        {
            while(arr[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo(arr[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j)
                break;
            SortUtil.exch(arr, i, j);
        }
        SortUtil.exch(arr, lo, j);
        return j;
    }

    public static void sort(Comparable[] arr, int lo, int hi)
    {
        if (lo >= hi)
            return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }
}