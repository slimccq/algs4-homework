package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 打印有序数组的公共元素
public class Exercise12_CommonElement {
    public static void main(String[] args) {
        int N = 20;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        StdOut.printf("first array: \n");
        int[] a = RandUtil.randIntArray(N);
        Arrays.sort(a);
        Utility.printArray(a);

        StdOut.printf("second array: \n");
        int[] b = RandUtil.randIntArray(N);
        Arrays.sort(b);
        Utility.printArray(b);

        StdOut.printf("common elements: \n");
        printCommonArrayElements(a, b);
    }

    public static void printCommonArrayElements(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if(a[i] > b[j]) {
                j++;
            } else {
                StdOut.printf("%d ", a[i]);
                i++;
                j++;
            }
        }
        StdOut.println();
    }
}
