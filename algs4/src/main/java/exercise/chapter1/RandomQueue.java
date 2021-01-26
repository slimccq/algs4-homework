package exercise.chapter1;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<E> implements Iterable<E> {
    private E[] array;
    private int N = 0;

    public RandomQueue() {
        this(1);
    }

    public RandomQueue(int capacity) {
        array = (E[])new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int max) {
        E[] arr = (E[])new Object[max];
        for (int i = 0; i < N; i++) {
            arr[i] = array[i];
        }
        array = arr;
    }

    public void enqueue(E v) {
        if (array.length == N) {
            resize(2*N);
        }
        array[N++] = v;
    }

    // 返回随机元素并删除
    public E dequeue() {
        Random rnd = new Random();
        int i = Math.abs(rnd.nextInt()) % N;
        //System.out.printf("swap %d <--> %d\n", i, N-1);
        E target = array[i];
        array[i] = array[N-1];
        array[N-1] = null;
        N--;
        return target;
    }

    // 返回随机元素，不删除
    public E sample() {
        Random rnd = new Random();
        int i = rnd.nextInt() % N;
        return array[i];
    }

    // exercise 1.3.36
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        int idx = 0;

        @Override
        public boolean hasNext() {
            return idx < N;
        }

        @Override
        public E next() {
            return array[idx++];
        }
    }
}