package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.ArrayQueue;
import exercise.chapter1.GeneralizedQueue;
import exercise.chapter1.ListQueue;

// 数组和链表实现queue
public class Exercise38_GeneralizedQueue {
    public static void main(String[] args) {
        int N = 3;
        if (args.length > 2) {
            N = Integer.parseInt(args[1]);
        }
        Comparable a;

        GeneralizedQueue<Integer> queue1 = new ArrayQueue<>(N);
        for (int i = 1; i <= N; i++) {
            queue1.insert(i);
        }
        printQueue("new queue: ", queue1);
        deleteQueue(queue1);
        printQueue("after deletion: ", queue1);

        GeneralizedQueue<Integer> queue2 = new ListQueue<>();
        for (int i = 1; i <= N; i++) {
            queue2.insert(i);
        }
        printQueue("new queue: ", queue2);
        deleteQueue(queue2);
        printQueue("after deletion: ", queue2);
    }

    public static void deleteQueue(GeneralizedQueue<Integer> que) {
        if (que.isEmpty()) {
            return ;
        }
        int k = 0;
        int v = 0;

        // delete first item
        k = 1;
        v = que.delete(k);
        StdOut.printf("delete value %d at index %d\n", v, k);

        if (que.isEmpty()) {
            return ;
        }

        // delete last item
        k = que.size();
        v = que.delete(k);
        StdOut.printf("delete value %d at index %d\n", v, k);

        // delete half items
        int N = que.size();
        for (int i = N / 2; i < N; i++) {
            k = 1 + (i % que.size());
            v = que.delete(k);
            StdOut.printf("delete value %d at index %d\n", v, k);
        }
    }

    public static void printQueue(String msg, GeneralizedQueue<Integer> que) {
        StdOut.printf("%s", msg);
        for (Integer n : que) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}
