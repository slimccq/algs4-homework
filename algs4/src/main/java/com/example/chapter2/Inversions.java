package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;

// Exercise 2.2.19 计算倒置数量
public class Inversions
{
    public static long count(Comparable[] a) {
        Comparable[] b   = new Comparable[a.length];
        Comparable[] aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        long inversions = count(a, b, aux, 0, a.length - 1);
        return inversions;
    }

    private static long count(Comparable[] a, Comparable[] b, Comparable[] aux, int lo, int hi) {
        long inversions = 0;
        if (hi <= lo)
            return 0;
        int mid = lo + (hi - lo) / 2;
        inversions += count(a, b, aux, lo, mid);
        inversions += count(a, b, aux, mid+1, hi);
        inversions += merge(b, aux, lo, mid, hi);
        //assert inversions == countBrute(a, lo, hi);
        return inversions;
    }

    // merge and count
    private static long merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        long inversions = 0;

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) { a[k] = aux[j++]; inversions += (mid - i + 1); }
            else                        a[k] = aux[i++];
        }
        return inversions;
    }

    public static long countBrute(Comparable[] arr, int lo, int hi)
    {
        long count = 0;
        for (int i = lo; i <= hi; i++) {
            for (int j = i+1; j <= hi; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 100;
        int T = 10;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                T = Integer.parseInt(args[1]);
            }
        }

        Comparable[] arr = SortUtil.randomIntArray(N);
        long count = Inversions.count(arr);
        long count2 = Inversions.countBrute(arr, 0, arr.length - 1);
        if(count != count2) {
            throw new RuntimeException("invalid inversion count");
        }
        StdOut.printf("inversions count %d\n", count);
    }
}