package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;

public class MinPQ<E extends Comparable<E>> extends SortBase {
    private E[] arr = null;
    private int N = 0;

    public MinPQ(int capacity) {
        arr = (E[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    void resize(int newsize) {
        E[] array = (E[]) new Object[newsize + 1];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        this.arr = array;
    }

    public E top() {
        return arr[1];
    }

    //
    private void swim(int k) {
        while (k > 1 && less(arr, k, k / 2)) {
            exch(arr, k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k; // left child
            if (j < N && less(arr,j + 1, j))
                j++;
            if (!less(arr, j, k))
                break;
            exch(arr, k, j);
            k = j;
        }
    }

    public void insert(E v) {
        if (N + 1 > arr.length) {
            int newsize = Math.max(4, arr.length * 2);
            resize(newsize);
        }
        arr[++N] = v;
        swim(N);
    }

    public E delMin() {
        E item = arr[1];
        exch(arr, 1, N--);
        arr[N + 1] = null;
        sink(1);
        return item;
    }

    public static void main(String[] args) {
        final Integer[] arr = {
                127, 63, 169, 135, 26, 12, 29, 188, 66, 191,
                81, 175, 156, 12, 137, 184, 147, 89, 156, 115,
                182, 115, 181, 64, 38, 23, 138, 198, 54, 71,
                82, 76, 179, 148, 196, 12, 91, 131, 34, 12,
                2, 69, 196, 65, 23, 54, 145, 74, 5, 74,
                177, 198, 77, 7, 165, 36, 185, 35, 0, 141,
                83, 3, 63, 152, 124, 108, 35, 34, 81, 34,
                64, 143, 16, 115, 85, 41, 136, 7, 180, 20,
                198, 199, 148, 68, 164, 102, 33, 44, 76, 40,
                118, 84, 162, 30, 88, 118, 31, 35, 171, 197,
        };
        MinPQ<Integer> pq = new MinPQ<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer v = pq.delMin();
            StdOut.println(v);
        }
    }
}
