package com.example.chapter2;

public class Heap extends SortBase {

    private static void sink(Comparable[] arr, int k, int N)
    {
        while(2*k <= N)
        {
            int j = 2*k; // left child
            if (j < N && less(arr, j, j+1)) {
                j++; // right child
            }
            if (!less(arr, k, j))
                break;
            exch(arr, k, j);
            k = j;
        }
    }

    public static void sort(Comparable[] arr)
    {
        int N = arr.length;
        for (int k = N/2; k >= 1; k--) {
            sink(arr, k, N);
        }
        while(N > 1)
        {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    private static void siftDown(Comparable[] arr, int lo, int hi)
    {
        int root = lo;
        while(true)
        {
            int child = root * 2 + 1; // left child
            if (child >= hi) {
                break;
            }
            if (child+1 < hi && less(arr, child, child+1)) {
                child++; // right child
            }
            exch(arr, root, child);
            root = child;
        }
    }

    public static void sort1(Comparable[] arr)
    {
        int lo = 0;
        int hi = arr.length;

        // build heap with greatest element at top
        for (int i = (hi-1)/2; i >= 0; i--)
        {
            siftDown(arr, i, hi);
        }

        // pop elements, largest first, into end of data
        for (int i = hi - 1; i >= 0; i--) {
            exch(arr, 0, i);
            siftDown(arr, lo, i);
        }
    }
}
