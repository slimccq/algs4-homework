package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.Deque;

// deque
public class Exercise33_Deque {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            deque.pushLeft(i);
        }
        for(int n : deque) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();

        for (int i = 0; i < 10; i++) {
            int n = deque.popRight();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}