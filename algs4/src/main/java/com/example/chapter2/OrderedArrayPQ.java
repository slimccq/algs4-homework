package com.example.chapter2;

import java.util.Arrays;

public class OrderedArrayPQ<E extends Comparable<E>> implements PriorityQueue<E> {
    private E[] elm = null;
    private int N = 0;

    public OrderedArrayPQ() {
        this(1);
    }

    public OrderedArrayPQ(int capacity) {
        elm = (E[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    void resize(int newsize) {
        E[] array = (E[]) new Object[newsize + 1];
        for (int i = 0; i < elm.length; i++) {
            array[i] = elm[i];
        }
        this.elm = array;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    // 小于等于key的index，查找[lo, hi), 返回[lo, hi]
    public int binarySearch(E key)
    {
        int lo = 0;
        int hi = elm.length;
        while (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = elm[mid].compareTo(key);
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

    // 插入排序
    public void insert(E v) {
        if ( N >= elm.length) {
            resize(N*2);
        }
        int idx = binarySearch(v);
        for (int i = N; i > idx; i--) {
            elm[i] = elm[i-1];
        }
        elm[N++] = v;
    }

    public E delMax() {
        E v = elm[N-1];
        elm[N-1] = null;
        return v;
    }
}
