package exercise.chapter2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class SortUtil {
    public static int read = 0;
    public static int write = 0;

    // a[i] < a[j]
    static boolean less(Comparable[] a, int i, int j) {
        read += 2;
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
        write += 2;
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

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1]))
                return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] arr, int[] perm) {
        for (int i = 1; i < perm.length; i++) {
            if (less(arr[perm[i]], arr[perm[i - 1]]))
                return false;
        }
        return true;
    }

}