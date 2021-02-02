package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.ArrayStack;
import exercise.chapter1.ListQueue;

// 栈实现的队列
public class Exercise49_StackQueue {
    public static void main(String[] args) {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        StackQueue<Integer> que = new StackQueue <>();
        for (int i = 0; i < N; i++) {
            que.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            Integer n = que.dequeue();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }

    // 队列实现的栈
    public static class QueueStack<E> {
        private ListQueue<E> queue = new ListQueue<>();

        public int size() {
            return queue.size();
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public void push(E e) {
            int cursize = queue.size();
            queue.enqueue(e);

            // 把所有旧的数据项取出，并逐个压入队列
            for (int i = 0; i < cursize; i++) {
                E v = queue.dequeue();
                queue.enqueue(v);
            }
        }

        public E pop() {
            return queue.dequeue();
        }
    }

    // 栈实现的队列
    public static class StackQueue<E> {
        ArrayStack<E> s1 = new ArrayStack<>();
        ArrayStack<E> s2 = new ArrayStack<>();

        public int size() {
            return s1.size() + s2.size();
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        private void shift() {
            while (!s1.isEmpty()) {
                E v = s1.pop();
                s2.push(v);
            }
        }

        // O(1)
        public void enqueue(E e) {
            s1.push(e);
        }

        // O(N)
        public E dequeue() {
            if (s2.isEmpty()) {
                shift();
            }
            return s2.pop();
        }
    }
}
