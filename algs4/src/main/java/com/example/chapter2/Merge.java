package com.example.chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 归并排序
public class Merge extends SortBase
{

    public static void sort(Comparable[] arr) {
        sort3(arr);
    }

    public static void sort1(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort1(arr, aux, 0, arr.length - 1);
    }

    public static void sort1(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) // 0或1个元素，则已排好序
            return;
        int mid = lo + (hi - lo) / 2;
        sort1(arr, aux, lo, mid);
        sort1(arr, aux, mid + 1, hi);

        // 序列A[lo,mid]和A[mid+1,hi]都有序
        // A[mid] <= A[mid+1]则a序列全部数值都<=b序列
        if (arr[mid].compareTo(arr[mid+1]) <= 0) {
            return;
        }
        merge1(arr, aux, lo, mid, hi);
    }

    public static void merge1(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    // Exercise 2.2.10 将A[mid+1,hi]倒序归并，可以减少内循环的条件判断，但排序结果非稳定
    public static void merge2(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++) {
            aux[i] = arr[i];
        }
        for (int j = mid + 1; j <= hi; j++) {
            aux[j] = arr[hi - j + mid + 1];
        }
        int i = lo;
        int j = hi;
        for (int k = lo; k <= hi; k++) {
            if (aux[j].compareTo(aux[i]) < 0) {
                arr[k] = aux[j--];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public static void sort2(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        bottomUpSort(arr, aux);
    }

    // 自底向上循环，bottom-up sort
    public static void bottomUpSort(Comparable[] arr, Comparable[] aux) {
        int N = arr.length;
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += sz * 2) {
                int hi = Math.min(lo + sz * 2 - 1, N - 1);
                //StdOut.printf("merge range: [%d %d]\n", lo, hi);
                merge1(arr, aux, lo, lo + sz - 1, hi);
            }
        }
    }

    public static void sort3(Comparable[] arr) {
        // make a copy
        Comparable[] aux = new Comparable[arr.length];
        sort3(arr, aux, 0, arr.length - 1);
    }

    // 优化版归并排序
    public static void sort3(Comparable[] arr, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) // 0或1个元素，则已排好序
            return;

        // 小数组使用插入排序
        if (hi - lo < 12) {
            Insertion.binarySort(arr, lo, hi); // Exercise 2.2.11 小数组使用插入排序
        } else {
            int mid = lo + (hi - lo) / 2;
            sort3(arr, aux, lo, mid);
            sort3(arr, aux, mid + 1, hi);
            merge3(arr, aux, lo, mid, hi);
        }
    }

    //
    public static void merge3(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = 0;

        // arr[mid] <= arr[mid+1], 已经有序
        if (arr[mid].compareTo(arr[j]) <= 0) {
            return;
        }

        while (i <= mid && j <= hi) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                aux[k++] = arr[i++];
            } else {
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
            arr[lo + i] = aux[i];
        }
    }

    // Exercise 2.2.12
    // 把数组分块，每块单独选择排序，最后把所有块两两合并排序
    public static void sort4(Comparable[] arr) {
        final int N = arr.length;
        final int B = 20;
        int lo = 0;
        for (int hi = B; hi <= N; hi += B) {
            Insertion.binarySort(arr, lo, hi - 1);
            //StdOut.printf("range: %d-%d\n", lo, hi - 1);
            lo = hi;
        }
        if (lo < N) {
            Insertion.binarySort(arr, lo, N - 1);
            //StdOut.printf("range: %d-%d\n", lo, N - 1);
        }

        // 两两合并排序
        Comparable[] aux = new Comparable[N];
        for (int sz = B; sz < N; sz *= 2) {
            lo = 0;
            int hi = 2 * sz;
            while (hi <= N) {
                StdOut.printf("merge range: %d-%d-%d\n", lo, lo + sz, hi - 1);
                merge3(arr, aux, lo, lo + sz - 1, hi - 1);
                lo = hi;
                hi += 2 * sz;
            }
            int mid = lo + sz;
            if (mid < N) {
                StdOut.printf("merge range: %d-%d-%d\n", lo, mid, N - 1);
                merge3(arr, aux, lo, mid - 1, N - 1);
            }
            sz *= 2;
        }
    }

    // 原地归并排序, O(1)空间复杂度
    public static void sort5(Comparable[] arr) {
        sort5(arr, 0, arr.length - 1);
    }

    public static void sort5(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) // 0或1个元素，则已排好序
            return;
        int mid = lo + (hi - lo) / 2;
        sort5(arr, lo, mid);
        sort5(arr, mid + 1, hi);
        inPlaceMerge(arr, lo, mid, hi);
    }

    // 原地归并排序，退化为插入排序
    public static void inPlaceMerge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        // arr[mid] <= arr[mid+1]
        if (arr[mid].compareTo(arr[j]) <= 0) {
            return;
        }
        while (i <= mid && j <= hi) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                i++;
            } else {
                Comparable value = arr[j];
                int idx = j;
                // Shift all the elements between
                while (idx != i) {
                    arr[idx] = arr[idx - 1];
                    idx--;
                }
                arr[i++] = value;
                mid++;
                j++;
            }
        }
    }

    // Exercise 2.2.14 合并有序队列
    public static Queue<Comparable> mergeQueue(Queue<Comparable> q1, Queue<Comparable> q2) {
        Queue<Comparable> result = new ArrayDeque<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
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
        while (!q1.isEmpty()) {
            result.add(q1.remove());
        }
        while (!q2.isEmpty()) {
            result.add(q2.remove());
        }
        return result;
    }

    // Exercise 2.2.17 对链表排序
    public static LinkedList<Comparable> sortList(LinkedList<Comparable> list) {
        int N = list.size();
        if (N <= 1)
            return list;

        LinkedList<Comparable> left = new LinkedList<>();
        LinkedList<Comparable> right = new LinkedList<>();
        int cnt = 0;
        for (Comparable v : list) {
            if (cnt < N / 2) {
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
    public static LinkedList<Comparable> mergeList(LinkedList<Comparable> left, LinkedList<Comparable> right) {
        LinkedList<Comparable> result = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
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

    public static void testSortArray(int N) {
//        Integer[] arr2 = {
//                127, 63, 169, 135, 26, 12, 29, 188, 66, 191,
//                81, 175, 156, 12, 137, 184, 147, 89, 156, 115,
//                182, 115, 181, 64, 38, 23, 138, 198, 54, 71,
//                82, 76, 179, 148, 196, 12, 91, 131, 34, 12,
//                2, 69, 196, 65, 23, 54, 145, 74, 5, 74,
//                177, 198, 77, 7, 165, 36, 185, 35, 0, 141,
//                83, 3, 63, 152, 124, 108, 35, 34, 81, 34,
//                64, 143, 16, 115, 85, 41, 136, 7, 180, 20,
//                198, 199, 148, 68, 164, 102, 33, 44, 76, 40,
//                118, 84, 162, 30, 88, 118, 171, 31, 35, 197,
//        };

        Integer[] arr = SortUtil.randomIntArray(N);
        Integer[] copy = new Integer[N];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);

        Merge.sort4(arr);
        if (!SortUtil.isSorted(arr)) {
            throw new RuntimeException("array is not sorted");
        }
        for (int i = 0; i < N; i++) {
            if (!arr[i].equals(copy[i])) {
                String msg = String.format("sorted array mismatch at %d: %d != %d", i, arr[i], copy[i]);
                throw new RuntimeException(msg);
            }
        }
        StdOut.printf("array sorted OK\n");
    }

    public static void testSortList(int N) {
//        Integer[] arr = {
//                127, 63, 169, 135, 26, 12, 29, 188, 66, 191,
//                81, 175, 156, 12, 137, 184, 147, 89, 156, 115,
//                182, 115, 181, 64, 38, 23, 138, 198, 54, 71,
//                82, 76, 179, 148, 196, 12, 91, 131, 34, 12,
//                2, 69, 196, 65, 23, 54, 145, 74, 5, 74,
//                177, 198, 77, 7, 165, 36, 185, 35, 0, 141,
//                83, 3, 63, 152, 124, 108, 35, 34, 81, 34,
//                64, 143, 16, 115, 85, 41, 136, 7, 180, 20,
//                198, 199, 148, 68, 164, 102, 33, 44, 76, 40,
//                118, 84, 162, 30, 88, 118, 31, 35, 171, 197,
//        };
        Integer[] arr = SortUtil.randomIntArray(N);
        LinkedList<Comparable> list = SortUtil.arrayToList(arr);
        list = Merge.sortList(list);
        for (Comparable v : list) {
            StdOut.println(v);
        }
    }

    public static double benchmarkSort(int N, int T, int method) {
        double total = 0.0;
        Double[] arr = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                arr[i] = StdRandom.uniform() * 100;
            }
            Stopwatch timer = new Stopwatch();
            if (method == 1) {
                Merge.sort1(arr);
            } else if (method == 2) {
                Merge.sort2(arr);
            } else if (method == 3) {
                Merge.sort3(arr);
            } else if (method == 4) {
                Merge.sort4(arr);
            } else if (method == 5) {
                Merge.sort5(arr);
            }
            total += timer.elapsedTime();
            if (!SortUtil.isSorted(arr)) {
                throw new RuntimeException("array is not sorted");
            }
        }
        return total;
    }

    public static void showBenchmarks(int N, int T) {
        int[] methods = {1, 2, 3, 4, 5};
        for (int method : methods) {
            double t1 = benchmarkSort(N, T, method);
            StdOut.printf("merge sort%d: %.2f\n", method, t1);
        }
    }

    public static void main(String[] args) {
        int N = 100;
        int T = 10;
        if (args.length >= 1) {
            N = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                T = Integer.parseInt(args[1]);
            }
        }

        //showBenchmarks(N, T);
        testSortArray(N);
        //testSortList(N);
    }
}