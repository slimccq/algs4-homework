package com.example.chapter2;

public interface PriorityQueue<E extends Comparable<E>> {
    int size();

    boolean isEmpty();

    void insert(E v);

    E delMax();
}
