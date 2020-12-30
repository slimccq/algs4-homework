package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.RingBuffer;

// RingBuffer
public class Exercise39_RingBuffer {
    public static void main(String[] args) {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        RingBuffer<Integer> ring = new RingBuffer<>(N);
        for (int i = 1; i <= N; i++) {
            ring.produce(i);
            if (i % 3 == 0) {
                ring.consume();
            }
        }

        for (Integer n : ring) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}
