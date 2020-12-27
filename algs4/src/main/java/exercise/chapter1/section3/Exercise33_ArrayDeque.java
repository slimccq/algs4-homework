package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.ResizingArrayDeque;

public class Exercise33_ArrayDeque {
    public static void main(String args[]) {
        ResizingArrayDeque<Integer> deq = new ResizingArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            deq.pushLeft(i);
        }
        for (int i = 10; i < 20; i++) {
            deq.pushRight(i);
        }
        for (int n : deq) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();
        for (int i = 0; i < 10; i++) {
            int n = deq.popLeft();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
        for (int i = 0; i < 10; i++) {
            int n = deq.popRight();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}
