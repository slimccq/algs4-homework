package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.Steque;

// steque
public class Exercise32_Steque {
    public static void main(String[] args) {
        Steque<Integer> stq = new Steque<>();
        for (int i = 0; i < 10; i++) {
            stq.push(i);
        }
        for (int i = 0; i < 10; i++) {
            int n = stq.pop();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}
