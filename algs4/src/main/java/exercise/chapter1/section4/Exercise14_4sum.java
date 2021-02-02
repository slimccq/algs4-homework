package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 4sum
public class Exercise14_4sum {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] a = RandUtil.randIntArray(N);
        Utility.printArray(a);
        int cnt = fourSum(a);
        StdOut.printf("4sum: %d\n", cnt);

    }

    public static int fourSum(int[] a) {
        Arrays.sort(a);
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int target = -a[k]-a[j]-a[i];
                    int idx = BinarySearch.searchInt(a, k+1, a.length, target);
                    if (idx >= 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
