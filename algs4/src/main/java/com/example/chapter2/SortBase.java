package com.example.chapter2;

public class SortBase
{
    // a[i] < a[j]
    static boolean less(Comparable[] a, int i, int j) {
        if (a[i] == a[j])
            return false;    // optimization when reference equal
        return a[i].compareTo(a[j]) < 0;
    }

    // a < b
    static boolean less(Comparable a, Comparable b) {
        if (a == b)
            return false;    // optimization when reference equal
        return a.compareTo(b) < 0;
    }

    // v == w
    static boolean eq(Comparable v, Comparable w) {
        if (v == w) return true;    // optimization when reference equal
        return v.compareTo(w) == 0;
    }

    // swap a[i] and a[j]
    static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1]))
                return false;
        }
        return true;
    }

}