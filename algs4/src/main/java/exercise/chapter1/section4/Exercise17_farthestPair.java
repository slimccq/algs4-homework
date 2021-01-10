package exercise.chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

// 数组中值最遥远的一对
public class Exercise17_farthestPair {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        double[] a = RandUtil.randDoubleArray(N);
        ResultPair res = farthestPair2(a);
        Utility.printArray(a);
        StdOut.printf("farthest pair is: 【%d-%d】\n", res.start, res.end);
        if (res.start >= 0) {
            StdOut.printf("%.2f, %.2f\n", a[res.start], a[res.end]);
        }
    }

    // 最大值和最小值
    public static ResultPair farthestPair2(double[] arr) {
        ResultPair r = new ResultPair();
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                r.end = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                r.start = i;
            }
        }
        return r;
    }

    static class ResultPair {
        int start = -1;
        int end = -1;
    }
}
