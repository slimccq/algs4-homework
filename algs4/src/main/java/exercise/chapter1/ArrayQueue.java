package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ArrayQueue<E> implements GeneralizedQueue<E> {
    private E[] arr;
    private int N = 0;

    public static final int DEFAULT_CAPACITY = 4;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        arr = (E[]) new  Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void insert(E e) {
        arr[N++] = e;
    }

    @Override
    public E delete(int k) {
        if (k <= 0 || k > N) {
            return null;
        }
        E v = arr[k-1];
        for (int i = k; i < N; i++) {
            arr[i-1] = arr[i];
        }
        arr[--N] = null;
        return v;
    }

    public void enqueue(E e) {
        insert(e);
    }

    public E dequeue() {
        return delete(1);
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private int idx = 0;

        @Override
        public boolean hasNext() {
            return idx < N;
        }

        @Override
        public E next() {
            return arr[idx++];
        }
    }
}
