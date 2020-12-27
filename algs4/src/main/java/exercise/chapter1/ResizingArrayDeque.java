package exercise.chapter1;

import java.util.*;

// 动态数组实现的deque
public class ResizingArrayDeque<E> implements Iterable<E>
{
    private E[] a;
    private int N;

    public ResizingArrayDeque()
    {
        resize(1);
    }

    public void resize(int max)
    {
        E[] arr = (E[]) new Object[max];
        for (int i = 0; i < N; i++) {
            arr[i] = a[i];
        }
        a = arr;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(E e)
    {
        if (N == a.length) {
            resize(N * 2);
        }
        for (int i = N; i > 0; i--) {
            a[i] = a[i-1];
        }
        a[0] = e;
        N++;
    }

    public void pushRight(E e)
    {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = e;
    }

    public E popLeft()
    {
        E value = a[0];
        for (int i = 0; i < N-1; i++) {
            a[i] = a[i+1];
        }
        a[N-1] = null;
        N--;
        return value;
    }

    public E popRight()
    {
        E value = a[N-1];
        a[N-1] = null;
        N--;
        return value;
    }

    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        private int n = 0;
        public boolean hasNext() { return N > 0 && n != N; }
        public E next() { return a[n++]; }
    }

}