package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

// k路归并排序
public class KWayMerge
{
    public static class Range implements Comparable<Range>
    {
        Comparable[] arr = null;
        int begin = 0;
        int end = 0;

        public Range(Comparable[] a, int b, int e)
        {
            arr = a;
            begin = b;
            end = e;
        }

        public int size() {
            return end - begin + 1;
        }

        public int compareTo(Range other) {
            if (this == other) {
                return 0;
            }
            int sz1 = size();
            int sz2 = other.size();
            if (sz1 == 0 && sz2 == 0) {
                return 0;
            } else if (sz1 > 0 && sz2 == 0) {
                return 1;
            } else if (sz2 > 0 && sz1 == 0) {
                return -1;
            }
            Comparable a = arr[begin];
            Comparable b = other.arr[other.begin];
            return a.compareTo(b);
        }
    }

    //多路归并
    public static void sort(Comparable[] arr)
    {
        Comparable[] aux = new Comparable[arr.length];
        int K = 3; // 3路归并
        kwaySort(arr, aux, K, 0, arr.length - 1);
    }

    // Exercise 2.2.25 k-路归并排序
    public static void kwaySort(Comparable[] arr, Comparable[] aux, int k, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if (hi - lo < 16) {
            Insertion.binarySort(arr, lo, hi+1);
            return;
        }
        Range[] ranges = parseToRange(arr, k, lo, hi);
        if (ranges.length == k) {
            for (Range r : ranges) {
                kwaySort(arr, aux, k, r.begin, r.end);
            }
        }
        kwayMerge(arr, aux, k, lo, hi, ranges);
    }

    public static Range[] parseToRange(Comparable[] arr, int k, int lo, int hi)
    {
        int size = hi - lo + 1;
        if (size < k) {
            Range[] ranges = new Range[size];
            for (int i = 0; i < size; i++) {
                //StdOut.printf("range: %d-%d\n", lo+i, lo+i);
                ranges[i] = new Range(arr, lo+i, lo+i);
            }
            return ranges;
        }
        int gap = size / k;
        Range[] ranges = new Range[k];
        for (int i = 0; i < k; i++) {
            int begin = lo + i * gap;
            if (i > 0) {
                begin += 1;
            }
            int end = Math.min(lo + (i+1)*gap, hi);
            //StdOut.printf("range: %d-%d\n", begin, end);
            ranges[i] = new Range(arr, begin, end);
        }
        if (ranges[k-1].end < hi) {
            ranges[k-1].end = hi;
        }
        return ranges;
    }

    // k路归并
    public static void kwayMerge(Comparable[] arr, Comparable[] aux, int k, int lo, int hi, Range[] ranges)
    {
        PriorityQueue<Range> heap = new PriorityQueue<>(k);
        for (Range r : ranges)
        {
            heap.add(r);
        }
        int j = 0;
        for (int i = lo; i <= hi; i++) {
            if (heap.isEmpty()) {
                break;
            }
            Range r = heap.poll();
            if (r.size() > 0) {
                aux[j++] = arr[r.begin++];
            }
            if (r.size() > 0) {
                heap.add(r);
            }
        }
        while(heap.size() > 0) {
            Range r = heap.poll();
            if (r.size() > 0) {
                aux[j++] = arr[r.begin++];
            }
            if (r.size() > 0) {
                heap.add(r);
            }
        }

        // copy back to array
        for (int i = 0; i < j; i++) {
            arr[lo+i] = aux[i];
        }
    }

    public static void main(String[] args)
    {
        int N = 110;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
        }
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform(200);
        }
        KWayMerge.sort(arr);
        if (!SortUtil.isSorted(arr)) {
            throw new RuntimeException("array is not sorted");
        }
        StdOut.printf("array is sorted\n");
    }
}