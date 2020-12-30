package exercise.chapter1;

import java.util.Iterator;

// 动态数组实现的栈
public class ArrayStack<E> implements Iterable<E> {
    private E[] array;
    private int size = 0;

    public static final int DEFAULT_CAPACITY = 4;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }
        array = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newsize) {
        E[] array = (E[]) new Object[newsize];
        for (int i = 0; i < size; i++) {
            array[i] = this.array[i];
        }
        this.array = array;
    }

    public void push(E v) {
        if (size >= array.length) {
            resize(size * 2);
        }
        array[size++] = v;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E v = array[size - 1];
        array[size - 1] = null;
        size--;
        return v;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[size - 1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int idx = 0; // from bottom to top

        public boolean hasNext() {
            return idx < size;
        }

        public E next() {
            return array[idx++];
        }
    }
}
