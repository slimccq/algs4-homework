package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;

// 快速排序
public class Quick extends SortBase
{
    public static void sort(Comparable[] arr)
    {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi)
            return;
        if (hi - lo < 7) {
            Insertion.binarySort(A, lo, hi);
            return;
        }
        int j = partition(A, lo, hi);
        StdOut.printf("partion to range: %d-%d-%d\n", lo, j, hi);
        sort(A, lo, j - 1);
        sort(A, j + 1, hi);
    }

    public static int partition(Comparable[] A, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = A[lo];
        while (i < j) {
            while(A[++i].compareTo(pivot) < 0 && i < hi)
                ;
            while(pivot.compareTo(A[--j]) < 0 && j > lo)
                ;
            if (i < j) {
                StdOut.printf("exchange %d(%d) %d(%d)\n", i, A[i], j, A[j]);
                exch(A, i, j);
            }
        }
        StdOut.printf("exchange %d(%d) %d(%d)\n", lo, A[lo], j, A[j]);
        exch(A, lo, j);
        return j;
    }

    public static int partition0(Comparable[] arr, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        Comparable v = arr[lo];
        while(true)
        {
            while(arr[++i].compareTo(v) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (v.compareTo(arr[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j)
                break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    // Tony Hoare  partition scheme
    public static int partition2(Comparable[] A, int lo, int hi)
    {
        int i = lo - 1;
        int j = hi + 1;
        Comparable pivot = A[(hi + lo)/2];
        while(true)
        {
            while(A[++i].compareTo(pivot) < 0)
                ;
            while(A[++j].compareTo(pivot) > 0)
                ;
            if (i < j) {
                exch(A, i, j);
            } else {
                return j;
            }
        }
    }

    // Nico Lomuto partition scheme
    public static int partition1(Comparable[] A, int lo, int hi)
    {
        int i = lo;
        Comparable pivot = A[hi];
        for (int j = lo; j < hi; j++) {
            if (A[j].compareTo(pivot) < 0) {
                exch(A, i, j);
                i++;
            }
        }
        exch(A, i, hi);
        return i;
    }


    // Exercise 2.3.25
    public static void sort1(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi)
            return;
        if (hi - lo < 7) {
            Insertion.binarySort(A, lo, hi);
            return;
        }
        int j = partition(A, lo, hi);
        sort1(A, lo, j - 1);
        sort1(A, j + 1, hi);
    }

    public static void sort3way(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi)
            return;
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable pivot = A[lo];
        while (i <= gt) {
            int cmp = A[i].compareTo(pivot);
            if (cmp < 0)
                exch(A, lt++, i++);
            else if (cmp > 0)
                exch(A, i, gt--);
            else
                i++;
        }
        sort3way(A, lo, lt - 1);
        sort3way(A, gt + 1, hi);
    }

    // postcondition: a[lo..hi] is best-case input for quicksorting that subarray
    private static void best(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        best(a, lo, mid-1);
        best(a, mid+1, hi);
        exch(a, lo, mid);
    }

    // return the index of the median element among a[i], a[j], and a[k]
    public static int median3(Comparable[] A, int i, int j, int k)
    {
        return (less(A, i, j) ?
                (less(A, j, k) ? j : less(A, i, k) ? k : i) :
                (less(A, k, j) ? j : less(A, k, i) ? k : i) );

//        if (less(A, i, j)) {
//            if (less(A, j, k)) {
//                return j;
//            } else {
//                if (less(A, i, k)) {
//                    return k;
//                } else {
//                    return i;
//                }
//            }
//        } else {
//            if (less(A, k, j)) {
//                return j;
//            } else if (less(A, k, i)) {
//                return k;
//            } else {
//                return i;
//            }
//        }
    }

    public static void sort2(Comparable[] A)
    {
        sort2(A, 0, A.length - 1);
    }

    public static void sort2(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi)
            return;
        int n = hi - lo + 1;
        int m = median3(A, lo, lo + n/2, hi);
        exch(A, m, lo);
        int p = partition0(A, lo, hi);
        sort(A, lo, p - 1);
        sort(A, p + 1, hi);
    }

    public static void sort3(Comparable[] a)
    {
        iterativeSort(a, 0, a.length - 1);
    }

    // 非递归快排
    public static void iterativeSort(Comparable[] A, int lo, int hi)
    {
        if (lo >= hi) {
            return ;
        }

        // initialize stack
        int[] stack = new int[hi - lo + 1];
        int top = -1;

        // push initial values of lo and hi to stack
        stack[++top] = lo;
        stack[++top] = hi;

        while (top >= 0) {
            hi = stack[top--];
            lo = stack[top--];
            int p = partition0(A, lo, hi);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > lo) {
                stack[++top] = lo;
                stack[++top] = p - 1;
            }
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < hi) {
                stack[++top] = p + 1;
                stack[++top] = hi;
            }
        }
    }

    public static void sort4(Comparable[] A) {
        sort4(A, 0, A.length - 1);
    }

    // Exercise 2.3.22 three-way partitioning
    public static void sort4(Comparable[] a, int lo, int hi)
    {
        int n = hi - lo + 1;
        if (n <= 8) {
            Insertion.binarySort(a, lo, hi);
            return;
        }
        // use median-of-3 as partitioning element
        else if (n <= 40) {
            int m = median3(a, lo, lo + n/2, hi);
            exch(a, m, lo);
        }
        // use Tukey ninther as partitioning element
        else {
            int eps = n/8;
            int mid = lo + n/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[i], v))
                exch(a, ++p, i);
            if (i >= j) break;

            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        for (int k = hi; k >= q; k--)
            exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

    public void sort5(Comparable[] a)
    {
        dualPivotSort(a, 0, a.length - 1);
    }

    public void dualPivotSort(Comparable[] a, int lo, int hi)
    {
        if (lo >= hi)
            return;

        // make sure a[lo] <= a[hi]
        if (less(a, hi, lo))
            exch(a, lo, hi);

        int lt = lo + 1;
        int gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if (less(a, i, lo))
                exch(a, lt++, i++);
            else if (less(a, hi, i))
                exch(a, i, gt--);
            else i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        dualPivotSort(a, lo, lt - 1);
        if (less(a, lt, gt))
            dualPivotSort(a, lt+1, gt - 1);
        dualPivotSort(a, gt+1,hi);
    }


    public static void testArray(int N)
    {
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = StdRandom.uniform(100);
        }
        Quick.sort2(A);
        if (!SortUtil.isSorted(A)) {
            throw new RuntimeException("array is not sorted");
        }
        StdOut.printf("array sorted OK\n");
    }

    public static void main(String[] args)
    {
        int N = 100;
        int T = 10;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                T = Integer.parseInt(args[1]);
            }
        }
        testArray(N);
    }
}