package com.example.chapter2;

import edu.princeton.cs.algs4.StdDraw;

// 选择排序
public class Selection extends SortBase
{
    public static void sortFloat(Double[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i) {
                show(arr, i, min);
                Double tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void sort(Comparable[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (less(arr, j, min)) {
                    min = j;
                }
            }
            if (min != i) {
                exch(arr, min, i);
            }
        }
    }

    public static void sort(Comparable[] arr, int lo, int hi)
    {
        for (int i = lo; i < hi; i++)
        {
            int min = i;
            for (int j = i + 1; j < hi; j++)
            {
                if (less(arr, j, min)) {
                    min = j;
                }
            }
            if (min != i) {
                exch(arr, min, i);
            }
        }
    }

    private static void show(Double[] a, int i, int min) {
        StdDraw.setYscale(-a.length + i + 0.8, i + 0.8);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < i; k++)
            StdDraw.filledRectangle(k, a[k] * 0.3, 0.25, a[k] * 0.3);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < a.length; k++)
            StdDraw.filledRectangle(k, a[k] * 0.3, 0.25, a[k] * 0.3);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(min, a[min] * 0.3, 0.25, a[min] * 0.3);
    }

    public static void test()
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
        Selection.sort(arr);
        if (!SortUtil.isSorted(arr)) {
            throw new RuntimeException("array is not sorted");
        }
        for (int n : arr)
        {
            System.out.println(n);
        }
    }

    public static void showDraw(int n) {
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, n+1);
        StdDraw.setPenRadius(0.006);
        Double[] arr = SortUtil.randomDoubleArray(n);
        sortFloat(arr);
    }

    public static void main(String[] args)
    {
        showDraw(100);
    }
}