package exercise.common;

import edu.princeton.cs.algs4.StdOut;

public class Utility {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i % 10 == 0) {
                StdOut.println();
            }
            StdOut.printf("%2d, ", arr[i]);
        }
        StdOut.println();
    }
}
