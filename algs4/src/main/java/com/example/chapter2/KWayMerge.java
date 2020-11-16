package com.example.chapter2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

public class KWayMerge
{
    public static class Range
    {
        int begin = 0;
        int end = 0;

        Range(int b, int e)
        {
            begin = b;
            end = e;
        }

        int size() {
            return end - begin;
        }
    }

    //多路归并
    public static void sort(Comparable[] arr)
    {
        Comparable[] aux = new Comparable[arr.length];
        int K = 3;
        kwaySort(arr, aux, K, 0, arr.length - 1);
    }

    // Exercise 2.2.25 k-路归并排序
    public static void kwaySort(Comparable[] arr, Comparable[] aux, int k, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if (hi - lo <= 15) {
            Insertion.binarySort(arr, lo, hi+1);
            return;
        }
        Range[] ranges = parseToRange(k, lo, hi);
        if (ranges.length == k) {
            for (Range r : ranges) {
                kwaySort(arr, aux, k, r.begin, r.end);
            }
        }
        kwayMerge(arr, aux, k, lo, ranges);
    }

    public static Range[] parseToRange(int k, int lo, int hi)
    {
        int size = hi - lo;
        if (size < k) {
            Range[] ranges = {new Range(lo, hi)};
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
            ranges[i] = new Range(begin, end);
        }
        if (ranges[k-1].end < hi) {
            ranges[k-1].end = hi;
        }
        return ranges;
    }

    // k-路归
    public static void kwayMerge(Comparable[] arr, Comparable[] aux, int k, int lo, Range[] ranges)
    {
        int j = 0;
        PriorityQueue heap = new PriorityQueue(k);
        for (Range r : ranges)
        {
            for (int i = 0; i < r.size(); i++)
            {
                if (r.size() == 0) {
                    break;
                }
                int idx = r.begin++;
                heap.add(arr[idx]);
                if (heap.size() > k) {
                    aux[j++] = (Comparable) heap.poll();
                }
            }
        }
        while(heap.size() > 0) {
            aux[j++] = (Comparable) heap.poll();
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
    }
}