package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ArrayQueue<E> implements GeneralizedQueue<E> {
    private E[] arr = null;
    private int N = 0;

    public ArrayQueue() {
        this(1);
    }

    public ArrayQueue(int capacity) {
        arr = (E[]) new  Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(E e) {
        arr[N++] = e;
    }

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

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private int idx = 0;

        public boolean hasNext() {
            return idx < N;
        }

        public E next() {
            return arr[idx++];
        }
    }
}
