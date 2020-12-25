package exercise.chapter1.section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;
import exercise.common.Utility;

import java.util.Arrays;

//
public class Exercise9_Counter {
   public static void main(String[] args)
   {
       int N = 100;
       if (args.length > 1) {
           N = Integer.parseInt(args[1]);
       }
       int target = 17;
       int[] arr = RandUtil.randIntArray(N);
       Arrays.sort(arr);
       Utility.printArray(arr);

       Counter counter = new Counter("search");
       rank(arr, target, counter);
       StdOut.printf("search %d in array with #%d operations\n", target, counter.tally());
   }

    public static int rank(int[] a, int key, Counter counter) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            counter.increment();
            if (a[mid] >= key) {
                hi = mid;
            } else if (a[mid] < key) {
                lo = mid + 1;
            }
        }
        return lo;
    }
}