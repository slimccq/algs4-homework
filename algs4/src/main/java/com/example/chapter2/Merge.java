package com.example.chapter2;

import java.util.*;
import java.util.Queue;

import edu.princeton.cs.algs4.*;

// 归并排序
public class Merge
{
    public static void sort(Comparable[] arr)
    {
        //sort1(arr);
        sort2(arr);
    }

    public static void sort1(Comparable[] arr)
    {
        Comparable[] aux = new Comparable[arr.length];
        sort1(arr, aux, 0, arr.length - 1);
    }

    public static void sort1(Comparable[] arr,Comparable[] aux, int lo, int hi)
    {
        if (lo >= hi) // 0或1个元素，则已排好序
            return;
        int mid = lo + (hi - lo) / 2;
        sort1(arr, aux, lo, mid);
        sort1(arr, aux, mid + 1, hi);
        merge1(arr, aux, lo, mid, hi);
    }

    public static void merge1(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (SortUtil.less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }


    // 自底向上循环，bottom-up sort
    public static void bottomUpSort(Comparable[] arr, Comparable[] aux)
    {
        int N = arr.length;
        for (int sz = 1; sz < N; sz *= 2)
        {
            for (int lo = 0; lo < N - sz; lo += sz*2)
            {
                int hi = Math.min(lo + sz*2 - 1, N-1);
                StdOut.printf("merge range: [%d %d]\n", lo, hi);
                merge1(arr, aux, lo, lo+sz-1, hi);
            }
        }
    }

    public static void sort2(Comparable[] arr)
    {
        // make a copy
        Comparable[] aux = new Comparable[arr.length];
        sort2(arr, aux, 0, arr.length - 1);
    }

    // 优化版归并排序
    public static void sort2(Comparable[] arr,Comparable[] aux, int lo, int hi)
    {
        if (lo >= hi) // 0或1个元素，则已排好序
            return;

        // 小数组使用插入排序
        if (hi - lo < 12) {
            insertionSort(arr, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;
            sort2(arr, aux, lo, mid);
            sort2(arr, aux, mid + 1, hi);

            // 跳过已经有序
            if (arr[mid].compareTo(arr[mid+1]) <= 0) {
                // skip ordered array
            } else {
                merge2(arr, aux, lo, mid, hi);
            }
        }
    }

    //
    public static void merge2(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi)
        {
            if (arr[i].compareTo(arr[j]) <= 0) {
                aux[k++] = arr[i++];
            } else{
                aux[k++] = arr[j++];
            }
        }
        // rest of left half
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
        // rest of right half
        while (j <= hi) {
            aux[k++] = arr[j++];
        }
        // copy back to array
        for (i = 0; i < k; i++) {
            arr[lo+i] = aux[i];
        }
    }

    // Exercise 2.2.11 小数组使用插入排序
    public static void insertionSort(Comparable[] arr, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i++)
        {
            for (int j = i; j > lo && arr[j].compareTo(arr[j-1]) < 0; j--)
            {
                Comparable tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    // Exercise 2.2.12  O(1)空间复杂度
    // 把数组分块，每块单独选择排序，最后把所有块两两合并排序
    public static void sort3(Comparable[] arr)
    {
        final int N = arr.length;
        final int B = 16;
        if (N <= B) {
            insertionSort(arr, 0, N - 1);
            return ;
        }

        int blocks = N / B;
        if (N % B > 0) {
            blocks++;
        }

        // 把数组分块选择排序
        for (int i = 0; i < blocks; i++) {
            int end = Math.min((i + 1) * B, N);
            selectionSort(arr, i, end - 1);
        }

        // 两两合并排序
        // TODO:
        Comparable[] aux = new Comparable[B];
        for (int i = 1; i < i; i++) {
            int end = Math.min((i + 1) * B, N);
            merge2(arr, aux, (i - 1) * N, i * N, end - 1);
        }
    }

    public static void selectionSort(Comparable[] arr, int lo, int hi)
    {
        for (int i = lo; i <= hi; i++)
        {
            int min = i;
            for (int j = i+1; j <= hi; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                Comparable tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    // Exercise 2.2.16 找出有序子数组，再归并
    public static void sort4()
    {

    }

    // Exercise 2.2.25 k-路归并
    // https://github.com/dielhennr/k-way-mergesort/blob/master/KMerge.java
    public static void kwaySort(Comparable[] arr)
    {

    }


    // Exercise 2.2.14 合并有序队列
    public static Queue<Comparable> mergeQueue(Queue<Comparable> q1, Queue<Comparable> q2)
    {
        Queue<Comparable> result = new ArrayDeque<>();
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            Comparable v1 = q1.peek();
            Comparable v2 = q2.peek();
            // v1 <= v2
            if (v1.compareTo(v2) <= 2) {
                result.add(v1);
                q1.remove();
            } else {
                result.add(v2);
                q2.remove();
            }
        }
        while (!q1.isEmpty())
        {
            result.add(q1.remove());
        }
        while (!q2.isEmpty())
        {
            result.add(q2.remove());
        }
        return result;
    }

    // Exercise 2.2.17 对链表排序
    public static LinkedList<Comparable> sortList(LinkedList<Comparable> list)
    {
        int N = list.size();
        if (N <= 1)
            return list;

        LinkedList<Comparable> left = new LinkedList<>();
        LinkedList<Comparable> right = new LinkedList<>();
        int cnt = 0;
        for (Comparable v : list)
        {
            if (cnt < N/2) {
                left.addLast(v);
            } else {
                right.addLast(v);
            }
            cnt++;
        }
        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }

    // 合并两个有序链表
    public static LinkedList<Comparable> mergeList(LinkedList<Comparable> left, LinkedList<Comparable> right)
    {
        LinkedList<Comparable> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty())
        {
            Comparable item1 = left.peekFirst();
            Comparable item2 = right.peekFirst();
            // item1 <= item2
            if (item1.compareTo(item2) <= 0) {
                result.addLast(item1);
                left.removeFirst();
            } else {
                result.addLast(item2);
                right.removeFirst();
            }
        }
        while (!left.isEmpty()) {
            result.addLast(left.peekFirst());
            left.removeFirst();
        }
        while (!right.isEmpty()) {
            result.addLast(right.peekFirst());
            right.removeFirst();
        }
        return result;
    }

    public static void testSortArray()
    {
        final Integer[] arr1 = SortUtil.randomIntArray(39);

        Integer[] arr2 = {
                127,63,169,135,26,12,29,188,66,191,
                81,175,156,12,137,184,147,89,156,115,
                182,115,181,64,38,23,138,198,54,71,
                82,76,179,148,196,12,91,131,34,12,
                2,69,196,65,23,54,145,74,5,74,
                177,198,77,7,165,36,185,35,0,141,
                83,3,63,152,124,108,35,34,81,34,
                64,143,16,115,85,41,136,7,180,20,
                198,199,148,68,164,102,33,44,76,40,
                118,84,162,30,88,118,171, 31,35,197,
        };
        Merge.sort3(arr2);
        if (!SortUtil.isSorted(arr1)) {
            throw new RuntimeException("array is not sorted");
        }
        StdOut.printf("array is sorted");

    }

    public static void testSortList()
    {
        Integer[] arr = {
                127,63,169,135,26,12,29,188,66,191,
                81,175,156,12,137,184,147,89,156,115,
                182,115,181,64,38,23,138,198,54,71,
                82,76,179,148,196,12,91,131,34,12,
                2,69,196,65,23,54,145,74,5,74,
                177,198,77,7,165,36,185,35,0,141,
                83,3,63,152,124,108,35,34,81,34,
                64,143,16,115,85,41,136,7,180,20,
                198,199,148,68,164,102,33,44,76,40,
                118,84,162,30,88,118,31,35,171,197,
        };
        LinkedList<Comparable> list = SortUtil.arrayToList(arr);
        list = Merge.sortList(list);
        for (Comparable v : list)
        {
            StdOut.println(v);
        }
    }

    public static double benchmarkSort(int N, int T, int method)
    {
        double total = 0.0;
        Double[] arr = new Double[N];
        for (int t = 0; t < T; t++)
        {
            for (int i = 0; i < N; i++) {
                arr[i] = StdRandom.uniform() * 100;
            }
            Stopwatch timer = new Stopwatch();
            if (method == 1) {
                Merge.sort1(arr);
            } else if (method == 2) {
                Merge.sort2(arr);
            }
            total += timer.elapsedTime();
            if (!SortUtil.isSorted(arr)) {
                throw new RuntimeException("array is not sorted");
            }
        }
        return total;
    }

    public static void showBenchmarks(int N, int T) {
        double t1 = benchmarkSort(N, T, 1);
        double t2 = benchmarkSort(N, T, 2);
        StdOut.printf("merge sort1: %.2f\n", t1);
        StdOut.printf("merge sort2: %.2f\n", t2);
    }

    public static void main(String[] args)
    {
        //showBenchmarks(10000, 100);
        testSortArray();
        //testSortList();
    }
}