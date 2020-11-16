package com.example.chapter2;

public class MinHeap<E extends Comparable<E>>
{
    private E[] arr = (E[])new Object[1];
    private int N = 0;

    void resize(int newsize)
    {
        E[] array = (E[])new Object[newsize];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        this.arr = array;
    }

    public E top()
    {
        return arr[0];
    }

    //
    private void swimUp(int k)
    {
        // swap k with his parent
        while(k > 0) {
            int j = (k - 1) / 2; // parent
            if (!SortUtil.less(arr, j, k)) {
                break;
            }
            SortUtil.exch(arr, j, k);
            k = j;
        }
    }

    private void downSink(int k)
    {
        while(true)
        {
            int i = 2 * k + 1; // left child
            if (i >= N) {
                break;
            }
            int j = i;
            if (i + 1 < N && SortUtil.less(arr, i+1, i)) {
                j = i + 1; // right child less
            }
            if (!SortUtil.less(j, k)) {
                break;
            }
            SortUtil.exch(arr, j, k);
            k = j;
        }
    }

    public void push(E v)
    {
        if (N + 1 > arr.length) {
            int newsize = Math.max(4, arr.length * 2);
            resize(newsize);
        }
        arr[N++] = v;
        swimUp(N-1);
    }

    public void pop()
    {
        SortUtil.exch(arr, 0, N-1);
        N--;
        downSink(0);
    }
}