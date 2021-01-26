package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.*;

// 计算出相等的整数对
public class Exercise8_CountPair {
    public static void main(String[] args) {
        int N = 20;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N);
        int cnt = countPairs2(arr);
        Utility.printArray(arr);
        StdOut.printf("equal pairs: %d\n", cnt);
    }

    public static int countPairs(int[] a) {
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] == a[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 排序
    public static int countPairs2(int[] a) {
        int N = a.length;
        int cnt = 0;
        int freq = 0;
        Arrays.sort(a);
        for (int i = 1; i < N; i++) {
            if (a[i] == a[i-1]) {
                freq++;
            } else {
                cnt += (freq+1)/2;
                freq = 0;
            }
        }
        // last one
        if (freq > 0) {
            cnt += (freq+1)/2;
        }
        return cnt;
    }

    // 使用集合
    public static int countPairs3(int[] a) {
        int cnt = 0;
        int N = a.length;
        Map<Integer, Integer> map = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            int occur = map.getOrDefault(a[i], 0);
            map.put(a[i], occur+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue() / 2;
        }
        return cnt;
    }

    // 排序后二分查找
    public static int countPairs4(int[] a) {
        int cnt = 0;
        int N = a.length;
        Arrays.sort(a); // quick sort
        for (int i = 0; i < N; i++) {
            int freq = BinarySearch.countInt(a, i + 1, N, a[i]);
            cnt += freq / 2;
        }
        return cnt;
    }
}
