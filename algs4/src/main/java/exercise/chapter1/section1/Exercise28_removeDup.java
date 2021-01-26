package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 删除重复元素
public class Exercise28_removeDup {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N);
        arr[N-1] = 100;

        // 排序后删除重复值
        Arrays.sort(arr);
        Utility.printArray(arr);
        arr = removeDup(arr);

        StdOut.printf("after remove dup:\n");
        Utility.printArray(arr);

        Integer[] a = RandUtil.randIntegerArray(N);
        Arrays.sort(a);
        Integer[] dup = removeDup(a);
        StdOut.printf("after remove dup:\n");
        Utility.printArray(dup);
    }

    // 删除重复
    public static int[] removeDup(int[] sorted) {
        if (sorted.length <= 1) {
            return sorted;
        }
        int[] copy = new int[sorted.length];
        copy[0] = sorted[0];
        int idx = 0;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != copy[idx]) {
                copy[++idx] = sorted[i];
            }
        }
        return Arrays.copyOfRange(copy, 0, idx+1);
    }

    // 删除重复(原地删除）
    public static Integer[] removeDup(Integer[] sorted) {
        if (sorted.length <= 1) {
            return sorted;
        }
        int idx = 0;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i].equals(sorted[idx])) {
                sorted[i] = null;
            } else {
                sorted[++idx] = sorted[i];
            }
        }
        for (int i = idx; i < sorted.length; i++) {
            sorted[i] = null;
        }
        return sorted;
    }
}
