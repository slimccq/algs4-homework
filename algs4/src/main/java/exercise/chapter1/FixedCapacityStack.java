package exercise.chapter1;

import java.util.Iterator;

// 固定长度的栈
public class FixedCapacityStack<E> implements Iterable<E> {
    private E[] array;
    private final int capacity;
    private int size = 0;

    public static final int DEFAULT_CAPACITY = 4;

    public FixedCapacityStack() {
        this(DEFAULT_CAPACITY);
    }

    public FixedCapacityStack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E e) {
        int idx = size++ % capacity; // will overwrite old data
        array[idx] = e;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    public E pop() {
        if (size == 0) {
            return null;
        }
        E e = array[size - 1];
        array[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int idx = 0; // from bottom to top

        @Override
        public boolean hasNext() {
            return idx < size;
        }

        @Override
        public E next() {
            return array[idx++];
        }
    }
}