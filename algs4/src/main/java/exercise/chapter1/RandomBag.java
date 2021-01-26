package exercise.chapter1;

import exercise.common.RandUtil;

import java.util.Iterator;

// 随机背包
public class RandomBag implements Iterable<Object> {
    private Object[] bag = null;
    private int N = 0;

    public RandomBag() {
        this(1);
    }

    public RandomBag(int capacity) {
        bag = new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int max) {
        Object[] arr = new Object[max];
        for (int i = 0; i < N; i++) {
            arr[i] = bag[i];
        }
        bag = arr;
    }

    public void add(Object e) {
        if (bag.length == N) {
            resize(2 * N);
        }
        bag[N++] = e;
    }

    @Override
    public Iterator<Object> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Object> {
        int idx = 0;

        BagIterator() {
            // 打乱顺序
            RandUtil.shuffleArray(bag, N);
        }

        @Override
        public boolean hasNext() {
            return idx < N;
        }

        @Override
        public Object next() {
            return bag[idx++];
        }
    }
}