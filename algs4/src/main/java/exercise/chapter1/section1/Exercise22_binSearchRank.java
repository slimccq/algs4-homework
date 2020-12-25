package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;

import java.util.Arrays;

// 打印BinarySearch递归深度
public class Exercise22_binSearchRank {
    public static void main(String[] args)
    {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        int[] arr = RandUtil.randIntArray(N);
        Arrays.sort(arr);
        int target = RandUtil.randInt(N);
        int idx = rank(arr, target, 0, arr.length, 0);
        StdOut.printf("find %d at %d\n", target, idx);
    }

    public static int rank(int[] sorted, int key, int lo, int hi, int depth)
    {
        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }
        StdOut.printf("search range [%d, %d)\n", lo, hi);
        if (lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key == sorted[mid]) {
                return mid;
            } else if (key < sorted[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            return rank(sorted, key, lo, hi, depth+1);
        }
        return -1;
    }
}
