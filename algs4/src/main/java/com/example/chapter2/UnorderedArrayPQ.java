package com.example.chapter2;

public class UnorderedArrayPQ<E extends Comparable<E>> implements PriorityQueue<E> {
    private E[] elm = null;
    private int N = 0;

    public UnorderedArrayPQ() {
        this(1);
    }

    public UnorderedArrayPQ(int capacity) {
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

    public void insert(E v) {
        if (N >= elm.length) {
            resize(N * 2);
        }
        elm[N++] = v;
    }

    public E delMax() {
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            if (elm[i].compareTo(elm[maxIdx]) > 0) {
                maxIdx = i;
            }
        }
        if (maxIdx > 0) {
            E v = elm[maxIdx];
            elm[maxIdx] = elm[N-1];
            elm[N-1] = null;
            return v;
        } else {
            E v = elm[maxIdx];
            elm[maxIdx] = null;
            return v;
        }
    }
}
