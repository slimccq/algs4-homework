package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;

// 间接排序
public class InDirect
{
    public static class ArrayPointer implements Comparable<ArrayPointer>
    {
        Comparable[] arr = null;
        int index = 0;

        public ArrayPointer(Comparable[] arr, int i) {
            this.arr = arr;
            this.index = i;
        }

        public int compareTo(ArrayPointer other) {
            return arr[index].compareTo(other.arr[other.index]);
        }
    }

    // Exercise 2.2.20 间接排序
    public static int[] sort(Comparable[] arr)
    {
        ArrayPointer[] pointers = new ArrayPointer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pointers[i] = new ArrayPointer(arr, i);
        }
        Merge.sort3(pointers);
        int[] perm = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            perm[i] = pointers[i].index;
        }
        return perm;
    }

    public static void testIndirectSort(int N)
    {
        Integer[] arr = SortUtil.randomIntArray(N);
        int[] perm =InDirect.sort(arr);
//        for (int i = 0; i < perm.length; i++) {
//            StdOut.printf("%d\n", arr[perm[i]]);
//        }
        if (!SortUtil.isSorted(arr, perm)) {
            throw new RuntimeException("array is not sorted");
        }
        StdOut.printf("array sorted OK\n");
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

        testIndirectSort(N);
    }
}