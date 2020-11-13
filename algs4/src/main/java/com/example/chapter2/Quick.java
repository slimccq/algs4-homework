package com.example.chapter2;

// 快速排序
public class Quick
{
    public static void sort(Comparable[] arr)
    {

    }

    public static int partition(Comparable[] arr, int lo, int hi)
    {
        return lo;
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