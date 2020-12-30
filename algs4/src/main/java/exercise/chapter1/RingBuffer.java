package exercise.chapter1;

import java.util.Iterator;

public class RingBuffer<E> implements Iterable<E> {
    private E[] buffer;
    private final int capacity;
    private int reader = 0;
    private int writer = -1;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (E[]) new Object[capacity];
    }

    // add item
    public void produce(E v) {
        // overwrite old data
        buffer[++writer % capacity] = v;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int idx = reader++ % capacity;
        return buffer[idx];
    }

    public E consume() {
        if (isEmpty()) {
            return null;
        }
        int idx = reader++ % capacity;
        E v = buffer[idx];
        buffer[idx] = null;
        return v;
    }

    public int size() {
        return writer - reader + 1;
    }

    public boolean isEmpty() {
        return writer < reader;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public Iterator<E> iterator() {
        return new RingIterator();
    }

    public class RingIterator implements Iterator<E> {
        private int idx = reader;

        public boolean hasNext() {
            return idx <= writer;
        }

        public E next() {
            return buffer[idx++ % capacity];
        }
    }
}
