package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

// 数组中值最接近的一对
public class Exercise16_ClosestPair {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        double[] a = RandUtil.randDoubleArray(N);
        ResultPair res = closestPair(a);
        Utility.printArray(a);
        StdOut.printf("closest pair is: 【%d-%d】\n", res.start, res.end);
        if (res.start >= 0) {
            StdOut.printf("%.2f, %.2f\n", a[res.start], a[res.end]);
        }
    }

    // 先排序，再遍历
    public static ResultPair closestPair(double[] arr) {
        ResultPair r = new ResultPair();
        Arrays.sort(arr); // quick sort, N * log(N)
        double diff = Double.MAX_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            double v = Math.abs(arr[i] - arr[i - 1]);
            if (v < diff) {
                r.start = i - 1;
                r.end = i;
                diff = v;
            }
        }
        return r;
    }

    static class ResultPair {
        int start = -1;
        int end = -1;
    }
}
