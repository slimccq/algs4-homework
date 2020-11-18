package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// 快速排序
public class Quick
{
    public static void sort(Comparable[] arr)
    {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static int partition(Comparable[] A, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = A[lo];
        while (i < j) {
            while(A[++i].compareTo(pivot) < 0 && i < hi)
                ;
            while(pivot.compareTo(A[--j]) < 0 && j > lo)
                ;
            if (i < j) {
                SortUtil.exch(A, i, j);
            }
        }
        SortUtil.exch(A, lo, j);
        return j;
    }

    public static int partition0(Comparable[] arr, int lo, int hi)
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

    // Tony Hoare  partition scheme
    public static int partition2(Comparable[] A, int lo, int hi)
    {
        int i = lo - 1;
        int j = hi + 1;
        Comparable pivot = A[(hi + lo)/2];
        while(true)
        {
            while(A[++i].compareTo(pivot) < 0)
                ;
            while(A[++j].compareTo(pivot) > 0)
                ;
            if (i < j) {
                SortUtil.exch(A, i, j);
            } else {
                return j;
            }
        }
    }

    // Nico Lomuto partition scheme
    public static int partition1(Comparable[] A, int lo, int hi)
    {
        int i = lo;
        Comparable pivot = A[hi];
        for (int j = lo; j < hi; j++) {
            if (A[j].compareTo(pivot) < 0) {
                SortUtil.exch(A, i, j);
                i++;
            }
        }
        SortUtil.exch(A, i, hi);
        return i;
    }


    public static void sort(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi)
            return;
//        if (hi - lo < 7) {
//            Insertion.binarySort(A, lo, hi);
//            return;
//        }
        int j = partition(A, lo, hi);
        StdOut.printf("partion to range: %d-%d-%d\n", lo, j, hi);
        sort(A, lo, j - 1);
        sort(A, j + 1, hi);
    }

    public static void testArray(int N)
    {
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = StdRandom.uniform(100);
        }
        Quick.sort(A);
        if (!SortUtil.isSorted(A)) {
            throw new RuntimeException("array is not sorted");
        }
        StdOut.printf("array sorted OK\n");
    }

    public static void main(String[] args)
    {
        int N = 100;
        int T = 10;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                T = Integer.parseInt(args[1]);
            }
        }
        testArray(N);
    }
}